package br.com.estudos.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class AberturaRepassePoloWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> arg0) throws Exception {
		System.out.println("Persistindo alteracoes");
		for (String string : arg0) {
			System.out.println("Persistindo: " + string);
		}
	}

}
