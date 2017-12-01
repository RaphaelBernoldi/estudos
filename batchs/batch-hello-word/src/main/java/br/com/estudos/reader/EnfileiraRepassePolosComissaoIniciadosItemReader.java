package br.edu.cruzeirodosul.reader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import br.edu.cruzeirodosul.bo.PoloComissaoBatchBO;

public class EnfileiraRepassePolosComissaoIniciadosItemReader
		implements ItemReader<PoloComissaoBatchBO> {

	@Override
	public PoloComissaoBatchBO read()
			throws Exception, UnexpectedInputException, ParseException,
			NonTransientResourceException {

		PoloComissaoBatchBO polosComissaoToEnfileiraBO = new PoloComissaoBatchBO();

		polosComissaoToEnfileiraBO.setControleCalculoComissao(10l);

		List<String> stringsPolosComissao = new ArrayList<>();
		stringsPolosComissao.add("poloComissao-1");
		stringsPolosComissao.add("poloComissao-2");
		stringsPolosComissao.add("poloComissao-3");
		stringsPolosComissao.add("poloComissao-4");
		stringsPolosComissao.add("poloComissao-5");
		polosComissaoToEnfileiraBO
				.setControlePolosComissao(stringsPolosComissao);

		return polosComissaoToEnfileiraBO;
	}

}
