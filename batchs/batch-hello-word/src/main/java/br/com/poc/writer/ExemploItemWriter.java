package br.com.poc.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class ExemploItemWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> items) throws Exception {
		
		System.out.println("Persistindo alteracoes");
		
		for (String string : items) {
			System.out.println("Persistindo: " + string);
		}
	}

}
