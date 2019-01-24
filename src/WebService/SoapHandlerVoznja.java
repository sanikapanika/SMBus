package WebService;

import java.io.IOException;
import java.util.ArrayList;
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

import model.Voznja;

public class SoapHandlerVoznja {
	
	// Metoda za upis u bazu
		public SOAPMessage createSOAPRequest(int id, String polaziste,
				String odrediste, int trajanjePutovanja,  String prevoznik) throws SOAPException, IOException {

			MessageFactory messageFactory = MessageFactory
					.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
			SOAPMessage soapMessage = messageFactory.createMessage();

			soapMessage.getMimeHeaders().addHeader("SOAPAction", "createVoznja");

			SOAPPart soapPart = soapMessage.getSOAPPart();

			SOAPEnvelope envelope = soapPart.getEnvelope();
			envelope.addNamespaceDeclaration("ssmtk",
					"http://schemas.xmlsoap.org/soap/envelope/");

			SOAPBody soapBody = envelope.getBody();
			SOAPElement soapBodyElem = soapBody.addChildElement("createVoznja",
					"ssmtk");

			SOAPElement soapBodyElem2 = soapBodyElem.addChildElement(
					"polaziste", "ssmtk");
			soapBodyElem2.addTextNode(polaziste);

			SOAPElement soapBodyElem3 = soapBodyElem.addChildElement(
					"odrediste", "ssmtk");
			soapBodyElem3.addTextNode(odrediste);

			SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("trajanjePutovanja",
					"ssmtk");
			soapBodyElem4.addTextNode(Integer.toString(trajanjePutovanja));
			
			SOAPElement soapBodyElem5 = soapBodyElem.addChildElement(
					"prevoznik", "ssmtk");
			soapBodyElem5.addTextNode(prevoznik);
			
				
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

		// -----------Čitanje iz baze--------------//

		public SOAPMessage createSOAPRequest(int id) throws SOAPException,
				IOException {

			MessageFactory messageFactory = MessageFactory
					.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
			SOAPMessage soapMessage = messageFactory.createMessage();

			soapMessage.getMimeHeaders().addHeader("SOAPAction", "getVoznjaById");

			SOAPPart soapPart = soapMessage.getSOAPPart();

			SOAPEnvelope envelope = soapPart.getEnvelope();
			envelope.addNamespaceDeclaration("ssmtk",
					"http://schemas.xmlsoap.org/soap/envelope/");

			SOAPBody soapBody = envelope.getBody();
			SOAPElement soapBodyElem = soapBody.addChildElement("getVoznjaById",
					"ssmtk");


			soapMessage.saveChanges();
			return soapMessage;

		}

		public static Voznja parseSOAPResponse(SOAPMessage soapResponse)
				throws Exception {

			SOAPBody soapBody = soapResponse.getSOAPBody();

			Iterator i = soapBody.getChildElements();
			SOAPBodyElement elem = (SOAPBodyElement) i.next();
			//System.out.println(elem.getTextContent().toString());

			Iterator j=elem.getChildElements();
			SOAPBodyElement elem1 = (SOAPBodyElement) j.next();
			//System.out.println("elem: " + elem1.getValue().toString());
			
			Iterator k=elem1.getChildElements();
			
			ArrayList<String> Lista=new ArrayList<String>();
			while(k.hasNext()){
				SOAPElement elem2= (SOAPElement)k.next();
				Lista.add(elem2.getValue().toString());
				
			}
			Voznja voznja=new Voznja();
			voznja.setId(Integer.parseInt(Lista.get(0)));
			voznja.setPolaziste(Lista.get(1));
			voznja.setOdrediste(Lista.get(2));
			voznja.setTrajanjePutovanja(Lista.get(3));
			voznja.setPrevoznik(Lista.get(4));
					
			return voznja; 

		}

		//--------brisanje voznje------automatski i putnika------//
		
}
