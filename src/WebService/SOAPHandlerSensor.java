package WebService;

import model.sensorInfo;
import dao.DBConnection;
import WebService.getSensorInfo;

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

public class SOAPHandlerSensor {
	
	private static final String uri = "http://localhost:8081/SmartBusTerminal/services/getSensorInfo";

	public static SOAPMessage createSOAPRequest() throws UnsupportedOperationException, SOAPException, IOException {
		SOAPConnectionFactory sfc = SOAPConnectionFactory.newInstance();
	    SOAPConnection connection = sfc.createConnection();
		MessageFactory messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();
		
		SOAPEnvelope envelope = soapPart.getEnvelope();
		SOAPBody soapBody = envelope.getBody();
		
		soapMessage.getMimeHeaders().addHeader("SOAPAction","");
		
		envelope.addNamespaceDeclaration("soapenv","http://schemas.xmlsoap.org/soap/envelope/");
		envelope.addNamespaceDeclaration("web", "http://WebServiceIn");

		SOAPElement soapBodyElem = soapBody.addChildElement("getSensorValues", "web");
	
		soapMessage.saveChanges();
		
		SOAPMessage response = connection.call(soapMessage, uri);
		
		return response;
	}
	
	public static sensorInfo parseSOAPResponse(SOAPMessage soapResponse)
			throws Exception {
		
		SOAPBody soapBody = soapResponse.getSOAPBody();
		sensorInfo sensorValues = new sensorInfo();
		Iterator child = soapBody.getChildElements();
		while (child.hasNext()) {
			SOAPBodyElement element = (SOAPBodyElement) child.next();
			Iterator child2 = element.getChildElements();
			while (child2.hasNext()) {
				SOAPBodyElement element2 = (SOAPBodyElement) child2.next();
				Iterator child3 = element2.getChildElements();
				while (child3.hasNext()){
					SOAPBodyElement element3 = (SOAPBodyElement) child3.next();
					if (element3.getLocalName().endsWith("kabina"))
						sensorValues.setKabina(element3.getTextContent());
					else if (element3.getLocalName().endsWith("prtljaznik"))
						sensorValues.setPrtljaznik(element3.getTextContent());
					else if (element3.getLocalName().endsWith("motor"))
						sensorValues.setMotor(element3.getTextContent());
				}
			}
		}
		return sensorValues;
	}
}
			

