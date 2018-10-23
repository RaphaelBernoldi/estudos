package br.com.estudos.processor;

import org.springframework.batch.item.ItemProcessor;

import br.com.estudos.bo.PoloComissaoBatchBO;

public class FinalizaCalculoRepassePoloComissaoItemProcessor
		implements ItemProcessor<PoloComissaoBatchBO, PoloComissaoBatchBO> {

	@Override
	public PoloComissaoBatchBO process(PoloComissaoBatchBO item)
			throws Exception {
		if (item.getControlePolosComissao() == null
				|| item.getControlePolosComissao().isEmpty()) {

			item.setControleCalculoComissao(10l);// Nesse caso o controle
													// calculo comissao vai
													// para status de FINALIZADO
			System.out.println("controleCalculoComissao = FINALIZADO");
			return item;
		}

		System.out.println(
				"SE NÃO TIVER CONTA CORRENTE, O SISTEMA BARRA A CONTINUACAO");
		System.out.println("//SUMARIZA");
		System.out.println("//FAZ O LANÇAMENTO");
		System.out.println("//FINALIZA O CONTROLE POLO COMISSAO");
		item.getControlePolosComissao().forEach(poloComissao -> {
			poloComissao = "poloComissao-1-first-FINALIZADO";
			// data final = agora()
			System.out.println("Atualiza data final");
		});
		return item;
	}

}
