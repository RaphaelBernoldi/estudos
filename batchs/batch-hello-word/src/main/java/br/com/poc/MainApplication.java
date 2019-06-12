package br.com.poc;

import javax.xml.bind.JAXBException;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import br.com.poc.model.acpo021.v1.CliComplexType;
import br.com.poc.model.acpo021.v1.EnvoCadComplexType;
import br.com.poc.model.acpo021.v1.ObjectFactory;
import br.com.poc.util.ConvertXML;

@SpringBootApplication	
@ComponentScan({ "br.com.poc.*" })
@EnableBatchProcessing
@EnableScheduling
public class MainApplication {
	
	

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MainApplication.class, args);
		
	}

	
	private static void test() {
		ObjectFactory objectFactory = new ObjectFactory();
		EnvoCadComplexType createEnvoCadComplexType = objectFactory.createEnvoCadComplexType();
		CliComplexType createCliComplexType = objectFactory.createCliComplexType();
		
		createCliComplexType.setIdfcCli(1);
		createCliComplexType.setNmCli("123.45.474");
		createCliComplexType.setTipCli("1");
		createCliComplexType.toString();
		
		createEnvoCadComplexType.setCnpjOgm(10123456000101l);
		createEnvoCadComplexType.setDtRms("20190504-1107"); 
		createEnvoCadComplexType.getCli().add(createCliComplexType);
		
		try {
			ConvertXML.testToXml(EnvoCadComplexType.class, createEnvoCadComplexType);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
