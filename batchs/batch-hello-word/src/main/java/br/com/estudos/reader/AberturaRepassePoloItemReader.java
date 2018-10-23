package br.com.estudos.reader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class AberturaRepassePoloItemReader implements ItemReader<List<String>> {

	@Override
	public List<String> read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {

		System.out.println(
				"Buscando todos os ControleCalculoComissao com status de pendente");

		List<String> strings = new ArrayList<>();

		strings.add("primeira string");
		strings.add("segunda string");
		strings.add("terceira string");
		return strings;
	}

}
