package br.edu.cruzeirodosul.reader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import br.edu.cruzeirodosul.bo.PoloComissaoBatchBO;

public class FinalizaCalculoRepassePoloComissaoItemReader
		implements ItemReader<PoloComissaoBatchBO> {

	@Override
	public PoloComissaoBatchBO read()
			throws Exception, UnexpectedInputException, ParseException,
			NonTransientResourceException {
		PoloComissaoBatchBO poloComissaoBatchBO = new PoloComissaoBatchBO();
		poloComissaoBatchBO.setControleCalculoComissao(10l);

		List<String> stringsPolosComissao = new ArrayList<>();
		stringsPolosComissao.add("poloComissao-1-first-CALCULADO");
		poloComissaoBatchBO.setControlePolosComissao(stringsPolosComissao);

		return poloComissaoBatchBO;
	}

}
