package br.com.estudos.reader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import br.com.estudos.bo.PoloComissaoBatchBO;

public class IniciaCalculoRepassePoloComissaoItemReader
		implements ItemReader<PoloComissaoBatchBO> {

	@Override
	public PoloComissaoBatchBO read()
			throws Exception, UnexpectedInputException, ParseException,
			NonTransientResourceException {

		PoloComissaoBatchBO comissaoBatchBO = new PoloComissaoBatchBO();

		comissaoBatchBO.setControleCalculoComissao(10l);

		List<String> stringsPolosComissao = new ArrayList<>();
		stringsPolosComissao.add("poloComissao-1-first-PENDENTE");
		comissaoBatchBO.setControlePolosComissao(stringsPolosComissao);

		return comissaoBatchBO;
	}

}
