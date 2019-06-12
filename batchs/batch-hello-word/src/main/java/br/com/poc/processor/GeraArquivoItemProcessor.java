package br.com.poc.processor;

import org.springframework.batch.item.ItemProcessor;

import br.com.poc.model.acpo021.v1.CliComplexType;

public class GeraArquivoItemProcessor implements ItemProcessor<CliComplexType, CliComplexType> {

	
	@Override
	public CliComplexType process(CliComplexType item) throws Exception {
		return item;
	}

}
