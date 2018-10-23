package br.com.estudos.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import br.com.estudos.bo.PoloComissaoBatchBO;

public class IniciaCalculoRepassePoloComissaoItemWriter
		implements ItemWriter<PoloComissaoBatchBO> {

	@Override
	public void write(List<? extends PoloComissaoBatchBO> items)
			throws Exception {
		items.forEach(poloComissaoBatch -> {
			poloComissaoBatch.getControlePolosComissao()
					.forEach(poloComissao -> {
						System.out.println("Gera títulos para " + poloComissao);
						System.out
								.println("controleCalculoComissao = CALCULADO");
						// controlePoloComissao.setStatusCalculo(StatusCalculo.CALCULADO);
						poloComissao = "poloComissao-1-first-CALCULADO";
					});
		});
	}

}
