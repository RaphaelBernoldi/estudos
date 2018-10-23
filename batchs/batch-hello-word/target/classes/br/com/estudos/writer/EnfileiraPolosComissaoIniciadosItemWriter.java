package br.com.estudos.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class EnfileiraPolosComissaoIniciadosItemWriter
		implements ItemWriter<Long> {

	@Override
	public void write(List<? extends Long> arg0) throws Exception {
		arg0.forEach(id -> {
			System.out.println("Atualizando status de controlePoloComissao: "
					+ id + " para enfileirado.");
		});
	}

}
