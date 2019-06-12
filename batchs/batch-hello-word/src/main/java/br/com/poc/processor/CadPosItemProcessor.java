package br.com.poc.processor;

import org.springframework.batch.item.ItemProcessor;

import br.com.poc.model.dto.ClientToProcDTO;

public class CadPosItemProcessor implements ItemProcessor<ClientToProcDTO, ClientToProcDTO> {

	@Override
	public ClientToProcDTO process(ClientToProcDTO item) throws Exception {
		System.out.println("ItemProcessor item " + item);
		/**
		 * Regras de negócio
		 */
		return item;
	}

}
