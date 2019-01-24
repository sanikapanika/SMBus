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

import model.Putnik;

public class SoapHandlerPutnik {
	
	// Metoda za upis u bazu
		public SOAPMessage createSOAPRequest(int idVoznje, String ime,
				String prezime, int starost, int brojPasosa) throws SOAPException, IOException {

			MessageFactory messageFactory = MessageFactory
					.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
			SOAPMessage soapMessage = messageFactory.createMessage();

			soapMessage.getMimeHeaders().addHeader("SOAPAction", "createPutnik");

			SOAPPart soapPart = soapMessage.getSOAPPart();

			SOAPEnvelope envelope = soapPart.getEnvelope();
			envelope.addNamespaceDeclaration("ssmtk",
					"http://schemas.xmlsoap.org/soap/envelope/");

			SOAPBody soapBody = envelope.getBody();
			SOAPElement soapBodyElem = soapBody.addChildElement("createPutnik",
					"ssmtk");

			SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("idVoznje", "ssmtk");
			soapBodyElem1.addTextNode(Integer.toString(idVoznje));

			SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("ime",
					"ssmtk");
			soapBodyElem2.addTextNode(ime);

			SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("prezime",
					"ssmtk");
			soapBodyElem3.addTextNode(prezime);

			SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("starost",
					"ssmtk");
			soapBodyElem4.addTextNode(Integer.toString(starost));

			SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("brojPasosa",
					"ssmtk");
			soapBodyElem5.addTextNode(Integer.toString(brojPasosa));

			
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

		public SOAPMessage createSOAPRequest(int idVoznje) throws SOAPException,
				IOException {

			MessageFactory messageFactory = MessageFactory
					.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
			SOAPMessage soapMessage = messageFactory.createMessage();

			soapMessage.getMimeHeaders().addHeader("SOAPAction", "getPutnikByIdVoznje");

			SOAPPart soapPart = soapMessage.getSOAPPart();

			SOAPEnvelope envelope = soapPart.getEnvelope();
			envelope.addNamespaceDeclaration("ssmtk",
					"http://schemas.xmlsoap.org/soap/envelope/");

			SOAPBody soapBody = envelope.getBody();
			SOAPElement soapBodyElem = soapBody.addChildElement("getPutnikByIdVoznje",
					"ssmtk");

			SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("idVoznje", "ssmtk");
			soapBodyElem1.addTextNode(Integer.toString(idVoznje));

			soapMessage.saveChanges();
			return soapMessage;

		}

		public static Putnik parseSOAPResponse(SOAPMessage soapResponse)
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
			Putnik putnik=new Putnik();
			
			putnik.setIdVoznje(Integer.parseInt(Lista.get(0)));
			putnik.setIme(Lista.get(1));
			putnik.setPrezime(Lista.get(2));
			putnik.setStarost(Integer.parseInt(Lista.get(3)));
			putnik.setBrojPasosa(Integer.parseInt(Lista.get(4)));
			
			return putnik; 

		}
		
		//-----------Brisanje iz baze podataka---------------//


}
