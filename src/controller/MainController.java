package controller;

import java.io.IOException;
import java.util.Iterator;

import javax.jws.WebService;
import javax.servlet.http.HttpServletResponse;
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
import model.sensorInfo;
import model.Voznja;
import model.log;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import WebService.SOAPHandlerSensor;
import WebService.SoapHandlerVoznja;
import WebService.SoapHandlerPutnik;

@Controller
public class MainController {
	
	private static final String uri = "http://localhost:8081/SmartBusTerminal/services/addVoznja";

	@RequestMapping(value = "/loginform")
	public ModelAndView loginform(HttpServletResponse response,
			@ModelAttribute log logi) throws IOException {
		ModelAndView modelandview = new ModelAndView("LoginForm");
		return modelandview;
	}
	
	@RequestMapping(value = "/loginform1")
	public ModelAndView loginform1(HttpServletResponse response,
			@ModelAttribute log logi) throws IOException {
		ModelAndView modelandview = new ModelAndView("LoginForm1");
		return modelandview;
	}
	@RequestMapping(value = "/loginform2")
	public ModelAndView loginform2(HttpServletResponse response,
			@ModelAttribute log logi) throws IOException {
		ModelAndView modelandview = new ModelAndView("LoginForm2");
		return modelandview;
	}


	@RequestMapping(value = "/Login")
	public String Login(@ModelAttribute log log) throws IOException, SOAPException {
			if (log.getUsername().equals("administrator") && log.getPassword().equals("12345")) {
				return "redirect:/AdminHome";
			} 
			else if (log.getUsername().equals("korisnik") && log.getPassword().equals("54321")) {
				return "redirect:/KorisnikHome";
			} 
			else {
				return "redirect:/loginform1";
			}
			
}

	@RequestMapping(value = "/Login1")
	public String Login1(@ModelAttribute log log) throws IOException, SOAPException {
			if (log.getUsername().equals("administrator") && log.getPassword().equals("12345")) {
				return "redirect:/AdminHome";
			} 
			else if (log.getUsername().equals("korisnik") && log.getPassword().equals("54321")) {
				return "redirect:/KorisnikHome";
			} 
			else {
				return "redirect:/loginform2";
			}
			
}
	@RequestMapping(value = "/Login2")
	public String Login2(@ModelAttribute log log) throws IOException, SOAPException {
			if (log.getUsername().equals("administrator") && log.getPassword().equals("12345")) {
				return "redirect:/AdminHome";
			} 
			else if (log.getUsername().equals("korisnik") && log.getPassword().equals("54321")) {
				return "redirect:/KorisnikHome";
			} 
			else {
				return "redirect:/error";
			}
			
}
	@RequestMapping(value = "/error")
	public ModelAndView error(HttpServletResponse response) throws IOException {
		ModelAndView modelandview = new ModelAndView("ErrorForm");
		return modelandview;
	}
	
	@RequestMapping(value = "/AdminHome")
	public ModelAndView AdminHome(HttpServletResponse response) throws IOException {
		ModelAndView modelandview = new ModelAndView("AdminHome");
		return modelandview;
	}
	@RequestMapping(value = "/KorisnikHome")
	public ModelAndView korisnikHome(HttpServletResponse response) throws IOException {
		ModelAndView modelandview = new ModelAndView("KorisnikHome");
		return modelandview;
	}
	@RequestMapping(value = "/addVoznjaForm")
	public ModelAndView addVoznjaForm(@ModelAttribute Voznja voznja,
			HttpServletResponse response) throws IOException {
		ModelAndView modelandview = new ModelAndView("addVoznjaForm");
		
		return modelandview;
	}

	@RequestMapping(value = "/addVoznja")
	public String addItem(@ModelAttribute Voznja voznja)
			throws Exception {
		SOAPMessage soapResponse = createSOAPRequest(voznja);
		return "redirect:/addVoznjaForm";
	}
	
	
	@RequestMapping(value = "/addPutnikForm")
	public ModelAndView addPutnikForm(@ModelAttribute Putnik putnik,
			HttpServletResponse response) throws IOException {
		ModelAndView modelandview = new ModelAndView("addPutnikForm");
		return modelandview;
	}

	@RequestMapping(value = "/addPutnik")
	public String addPutnik(@ModelAttribute Putnik putnik) throws IOException, SOAPException {		
		SoapHandlerPutnik handler=new SoapHandlerPutnik();
        SOAPMessage request=handler.createSOAPRequest(putnik.getIdVoznje(), putnik.getIme(), putnik.getPrezime(), putnik.getStarost(), putnik.getBrojPasosa());
        SOAPMessage response=handler.sendSOAPRequest(request,"http://localhost:12806/SmartBusTerminal/services/addPutnik");
        return "redirect:/addPutnikForm";
	}
	
	@RequestMapping(value = "/deletePutnikForm")
	public ModelAndView deletePutnikForm(@ModelAttribute Putnik putnik,
			HttpServletResponse response) throws IOException {
		ModelAndView modelandview = new ModelAndView("deletePutnikForm");
		return modelandview;
	}
	
	@RequestMapping(value = "/deleteVoznjaForm")
	public ModelAndView deleteVoznjaForm(@ModelAttribute Putnik putnik,
			HttpServletResponse response) throws IOException {
		ModelAndView modelandview = new ModelAndView("deleteVoznjaForm");
		return modelandview;
	}
	
	@RequestMapping(value = "/getPutnikForm")
	public ModelAndView getPutnikForm(@ModelAttribute Putnik putnik,
			HttpServletResponse response) throws IOException {
		ModelAndView modelandview = new ModelAndView("getPutnikForm");
		return modelandview;
	}
	
	@RequestMapping(value = "/getVoznjaForm")
	public ModelAndView getVoznjaForm(@ModelAttribute Putnik putnik,
			HttpServletResponse response) throws IOException {
		ModelAndView modelandview = new ModelAndView("getVoznjaForm");
		return modelandview;
	}
	
	@RequestMapping(value = "/getSensorsInfoForm")
	public ModelAndView getSensorsInfoForm(@ModelAttribute sensorInfo SensorInfo,
			HttpServletResponse response) throws IOException {
		ModelAndView modelandview = new ModelAndView("getSenosrsInfoForm");
		return modelandview;
	}
	
	public static SOAPMessage createSOAPRequest(Voznja voznja) throws UnsupportedOperationException, SOAPException, IOException {
		SOAPConnectionFactory sfc = SOAPConnectionFactory.newInstance();
	    SOAPConnection connection = sfc.createConnection();
		MessageFactory messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();
		
		SOAPEnvelope envelope = soapPart.getEnvelope();
		SOAPBody soapBody = envelope.getBody();
		
		soapMessage.getMimeHeaders().addHeader("SOAPAction","");
		
		envelope.addNamespaceDeclaration("soapenv","http://schemas.xmlsoap.org/soap/envelope/");
		envelope.addNamespaceDeclaration("web", "http://WebService");

		SOAPElement soapBodyElem = soapBody.addChildElement("createVoznja", "web");
	
		SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("voznja","web");
		soapBodyElem2.addTextNode("voznja");
		
		
		SOAPElement polaziste = soapBodyElem2.addChildElement("polaziste");
		polaziste.addTextNode(voznja.getPolaziste());
		SOAPElement odrediste = soapBodyElem2.addChildElement("odrediste");
		odrediste.addTextNode(voznja.getOdrediste());
		SOAPElement trajanjePutovanja = soapBodyElem2.addChildElement("trajanjePutovanja");
		trajanjePutovanja.addTextNode(voznja.getTrajanjePutovanja());
		SOAPElement prevoznik = soapBodyElem2.addChildElement("prevoznik");
		prevoznik.addTextNode(voznja.getPrevoznik());
		soapMessage.saveChanges();
		System.out.println(soapMessage);
		
		SOAPMessage response = connection.call(soapMessage, uri);
		
		return response;
	}
	 // addPutnik http://localhost:12806/SmartBusTerminal/services/addPutnik 
	 // addSensorInfo http://localhost:12806/SmartBusTerminal/services/addSensorInfo 
	 // addVoznja http://localhost:12806/SmartBusTerminal/services/addVoznja
	 // deleteutnik http://localhost:12806/SmartBusTerminal/services/deletePutnik
	 // deleteVoznja http://localhost:12806/SmartBusTerminal/services/deleteVoznja
	 // getPutnik http://localhost:12806/SmartBusTerminal/services/getPutnik
	 // getSensorInfo http://localhost:12806/SmartBusTerminal/services/getSensorInfo
	 // getVoznja http://localhost:12806/SmartBusTerminal/services/getVoznja
	
	

}