package br.edu.cruzeirodosul.processor;

import org.springframework.batch.item.ItemProcessor;

import br.edu.cruzeirodosul.bo.PoloComissaoBatchBO;

public class EnfileiraRepassePolosComissaoIniciadosItemProcessor
		implements ItemProcessor<PoloComissaoBatchBO, Long> {

	@Override
	public Long process(PoloComissaoBatchBO polosComissaoToEnfileiraBO)
			throws Exception {

		polosComissaoToEnfileiraBO.getControlePolosComissao()
				.forEach(poloComissao -> {
					System.out.println("poloComissao = " + poloComissao);
				});
		return polosComissaoToEnfileiraBO.getControleCalculoComissao();
	}

}
