package WebService;

import model.log;
import dao.DBConnection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

public class SOAPHandlerLogin{

// Metoda za upis u bazu
	
	public SOAPMessage createSOAPRequest(String username,
			String password) throws SOAPException, IOException {

		MessageFactory messageFactory = MessageFactory
				.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
		SOAPMessage soapMessage = messageFactory.createMessage();

		soapMessage.getMimeHeaders().addHeader("SOAPAction", "login");

		SOAPPart soapPart = soapMessage.getSOAPPart();

		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("ssmtk",
				"http://schemas.xmlsoap.org/soap/envelope/");

		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElem = soapBody.addChildElement("login",
				"ssmtk");

		SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("username", "ssmtk");
		soapBodyElem1.addTextNode(username);

		SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("password",
				"ssmtk");
		soapBodyElem2.addTextNode(password);

		soapMessage.saveChanges();
		return soapMessage;

	}

	public SOAPMessage sendSOAPRequest(SOAPMessage request, String url)
			throws UnsupportedOperationException, SOAPException {

		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory
				.newInstance();
		SOAPConnection soapConnection;

		soapConnection = soapConnectionFactory.createConnection();

		try {

			SOAPMessage response = soapConnection.call(request, url);

			soapConnection.close();
			return response;

		}

		catch (NumberFormatException e) {
			System.out.print("Greska prilikom slanja SOAP zahtjeva");

			soapConnection.close();

		}
		return request;
	}

	/*// -----------Čitanje iz baze--------------//

	public SOAPMessage createSOAPRequest(int id) throws SOAPException,
			IOException {

		MessageFactory messageFactory = MessageFactory
				.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
		SOAPMessage soapMessage = messageFactory.createMessage();

		soapMessage.getMimeHeaders().addHeader("SOAPAction", "getEmployeeById");

		SOAPPart soapPart = soapMessage.getSOAPPart();

		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("ssmtk",
				"http://schemas.xmlsoap.org/soap/envelope/");

		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElem = soapBody.addChildElement("getEmployeeById",
				"ssmtk");

		SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("id", "ssmtk");
		soapBodyElem1.addTextNode(Integer.toString(id));

		soapMessage.saveChanges();
		return soapMessage;

	}*/

	public static log parseSOAPResponse(SOAPMessage soapResponse)
			throws Exception {

		SOAPBody soapBody = soapResponse.getSOAPBody();

		Iterator i = soapBody.getChildElements();
		SOAPBodyElement elem = (SOAPBodyElement) i.next();
		//System.out.println(elem.getTextContent().toString());
		Iterator j=elem.getChildElements();
		SOAPBodyElement elem1 = (SOAPBodyElement) j.next();
		
		Iterator k=elem1.getChildElements();
		
		ArrayList<String> Lista=new ArrayList<String>();
		while(k.hasNext()){
			SOAPElement elem2= (SOAPElement)k.next();
			Lista.add(elem2.getValue().toString());
		}
		log userlog=new log();
		
		userlog.setUsername(Lista.get(0));
		userlog.setPassword(Lista.get(1));
		
		
		
		return userlog; 

	}

}
