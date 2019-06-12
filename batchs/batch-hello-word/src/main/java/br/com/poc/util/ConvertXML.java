package br.com.poc.util;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ConvertXML {

	public static <T> void testToXml(Class<T> type, T value) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(type);

		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		StringWriter sw = new StringWriter();

		jaxbMarshaller.marshal(value, sw);

		String xmlContent = sw.toString();
		System.out.println(xmlContent);
	}

	
	public static <T> void convertToXml(Class<T> type, T value, String pathFile) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(type);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); 
        marshaller.marshal(value, new File(pathFile));
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T> T testXmlToObject(Class<T> type, String pathFile) throws JAXBException{
		 File file = new File(pathFile);
	     return (T) testXmlToUnmarshaller(type, pathFile).unmarshal(file);
	}
	
	
	public static <T> Unmarshaller testXmlToUnmarshaller(Class<T> type, String pathFile) throws JAXBException{
	     JAXBContext jaxbContext = JAXBContext.newInstance(type);
	     return jaxbContext.createUnmarshaller();
	}

}
