package br.edu.cruzeirodosul.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import br.edu.cruzeirodosul.bo.PoloComissaoBatchBO;

public class FinalizaCalculoRepassePoloComissaoItemWriter
		implements ItemWriter<PoloComissaoBatchBO> {

	@Override
	public void write(List<? extends PoloComissaoBatchBO> items)
			throws Exception {
		items.forEach(item -> {
			item.getControlePolosComissao().forEach(controlePoloComissao -> {
				System.out.println("Salvando controlePoloComissao = "
						+ controlePoloComissao);
			});
		});
	}

}
