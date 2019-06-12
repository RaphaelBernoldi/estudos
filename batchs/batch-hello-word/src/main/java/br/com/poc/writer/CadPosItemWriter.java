package br.com.poc.writer;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.batch.item.ItemWriter;

import br.com.poc.model.acpo021.v1.CliComplexType;
import br.com.poc.model.acpo021.v1.EnvoCadComplexType;
import br.com.poc.model.dto.ClientToProcDTO;
import br.com.poc.util.ConvertXML;

public class CadPosItemWriter implements ItemWriter<ClientToProcDTO> {
	
	private Long fakeId = 1l;
	private EnvoCadComplexType envoCadComplexType;
	private Long numeroLote = 1l;

	public CadPosItemWriter() {
		envoCadComplexType = new EnvoCadComplexType();
	}
	
	
	@Override
	public void write(List<? extends ClientToProcDTO> items) throws Exception {
		System.out.println("ItemWriter recebido " + items.size());
		System.out.println(":::::Enviando lista para procedure::::");
		System.out.println("numeroLote = " + numeroLote);
		numeroLote++;
		
		items
			.stream()
			.findFirst()
			.ifPresent(i -> envoCadComplexType.setDtRms(i.getDate()));
	
		String path = "/home/raphael/Documents/cip/demandas/std_cadastro_positivo/output_test/XML_POC_TEST_"+ envoCadComplexType.getDtRms() +".xml";
		items
			.forEach(item -> {
					CliComplexType cliComplexType = new CliComplexType();
					cliComplexType.setIdfcCli(fakeId);
					cliComplexType.setTipCli("1");
					cliComplexType.setNmCli(item.getCpf() + "-" + RandomUtils.nextInt(00, 99));
					envoCadComplexType.getCli().add(cliComplexType);
					fakeId++;
			
		});
		
		if(items.size() < 100) {
			ConvertXML.convertToXml(EnvoCadComplexType.class, envoCadComplexType, path);
		}
		
		
	}
	

}
