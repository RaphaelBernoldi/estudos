package br.com.poc.reader;

import javax.xml.bind.JAXBException;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import br.com.poc.model.acpo021.v1.EnvoCadComplexType;
import br.com.poc.model.dto.ClientToProcDTO;
import br.com.poc.util.ConvertXML;

public class CadPosItemReader implements ItemReader<ClientToProcDTO>{

	private EnvoCadComplexType envoCadComplexType;
	private Integer index = 0;
	
	public CadPosItemReader() throws Exception{
		try {
			loadFile();
		} catch (JAXBException e) {
			throw new Exception("Falha ao ler arquivo -  " + e.getMessage());
		}
	}
	
	private void loadFile() throws JAXBException {
		String path = "/home/raphael/Documents/cip/demandas/std_cadastro_positivo/input_test/XML_POC_TEST.xml";
		 envoCadComplexType = ConvertXML.testXmlToObject(EnvoCadComplexType.class, path);
	}
	
	@Override
	public ClientToProcDTO read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		System.out.println("ItemReader " + index);
		
		if(index < envoCadComplexType.getCli().size()) {
			ClientToProcDTO clientToProcDTO = new ClientToProcDTO();
			clientToProcDTO.setDate(envoCadComplexType.getDtRms());
			clientToProcDTO.setCpf(envoCadComplexType.getCli().get(index).getNmCli());
			index ++;
			return clientToProcDTO;
		}
		
		 return null;
	}

	
	

}
