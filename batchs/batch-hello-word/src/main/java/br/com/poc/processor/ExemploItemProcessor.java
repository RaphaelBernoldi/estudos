package br.com.poc.processor;

import java.util.List;

import org.springframework.batch.item.ItemProcessor;

public class ExemploItemProcessor implements ItemProcessor<List<String>, String> {

	@Override
	public String process(List<String> item) throws Exception {
		System.out.println("Processando itens" + item.size());
		String retorno = "";
		
		for (String itemStr : item) {
			retorno += itemStr + " processado com sucesso!;";
		}

		return retorno;
	}

}
