package br.edu.cruzeirodosul.processor;

import java.util.List;

import org.springframework.batch.item.ItemProcessor;

public class AberturaRepassePoloProcessor
		implements ItemProcessor<List<String>, String> {

	@Override
	public String process(List<String> arg0) throws Exception {
		System.out.println("Processando abertura");
		arg0.forEach(string -> {
			string += "Processado!";
		});

		return "Processado!";
	}

}
