package br.edu.cruzeirodosul.processor;

import org.springframework.batch.item.ItemProcessor;

import br.edu.cruzeirodosul.bo.PoloComissaoBatchBO;

public class IniciaCalculoRepassePoloComissaoItemProcessor
		implements ItemProcessor<PoloComissaoBatchBO, PoloComissaoBatchBO> {

	@Override
	public PoloComissaoBatchBO process(PoloComissaoBatchBO item)
			throws Exception {

		if (item.getControlePolosComissao() == null
				|| item.getControlePolosComissao().isEmpty()) {
			item.setControleCalculoComissao(10l);// Nesse caso o controle
													// calculo comissao vai
													// poara status de calculado
			System.out.println("controleCalculoComissao == CALCULADO");
			return item;
		}
		item.getControlePolosComissao().forEach(controlePoloComissao -> {
			controlePoloComissao = "poloComissao-1-first-INICIADO";
			System.out.println("poloComissao == INICIADO");
			System.out.println("poloComissao.dataInicio = agora");
		});

		return item;
	}

}
