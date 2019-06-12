package br.com.poc.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import br.com.poc.model.acpo021.v1.CliComplexType;
import br.com.poc.model.acpo021.v1.EnvoCadComplexType;
import br.com.poc.util.ConvertXML;

public class GeraArquivoItemWriter implements ItemWriter<CliComplexType> {

	private EnvoCadComplexType envoCadComplexType;
	private String path;
	
	public GeraArquivoItemWriter() {
		envoCadComplexType = new EnvoCadComplexType();
		envoCadComplexType.setCnpjOgm(101234560000101l);
		envoCadComplexType.setDtRms("20190605");
		envoCadComplexType.setNmOgm("Teste");
		envoCadComplexType.setNrRms(123456);
		envoCadComplexType.setSeqlRms(10);
		path = "/home/raphael/Documents/cip/demandas/std_cadastro_positivo/input_test/XML_POC_TEST_INPUT_"+ envoCadComplexType.getDtRms() +".xml";
	
	}
	
	
	@Override
	public void write(List<? extends CliComplexType> items) throws Exception {
		envoCadComplexType.getCli().addAll(items);
		ConvertXML.convertToXml(EnvoCadComplexType.class, envoCadComplexType, path);
		
	}
}
