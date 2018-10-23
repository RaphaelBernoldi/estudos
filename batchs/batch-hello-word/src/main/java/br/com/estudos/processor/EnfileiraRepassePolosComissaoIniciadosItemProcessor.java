package br.com.estudos.processor;

import org.springframework.batch.item.ItemProcessor;

import br.com.estudos.bo.PoloComissaoBatchBO;

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
