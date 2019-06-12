package br.com.poc.reader;

import java.util.Random;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import br.com.poc.model.acpo021.v1.CliComplexType;
import br.com.poc.model.acpo021.v1.EndEtnCliComplexType;
import br.com.poc.model.acpo021.v1.TelCliComplexType;

public class GeraArquivoItemReader implements ItemReader<CliComplexType> {
	
	private Long totalAGerar = 10000000l;
	//private Long totalAGerar = 100L;
	private Long gerados = 0l;
	
	@Override
	public CliComplexType read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		if(gerados <= totalAGerar) {
			CliComplexType cliComplexType = new CliComplexType();
			cliComplexType.setIdfcCli(gerados);
			cliComplexType.setNmCli("Nome_teste_" + gerados);
			cliComplexType.setTipCli("1");
			
			EndEtnCliComplexType endEtnCliComplexType = new EndEtnCliComplexType();
			endEtnCliComplexType.setEmaiCli(cliComplexType.getNmCli() + "@gmail.com");
			cliComplexType.getEndEtnCli().add(endEtnCliComplexType);
			
			TelCliComplexType telCliComplexType = new TelCliComplexType();
			telCliComplexType.setDddTelCli(11);
			telCliComplexType.setNrTelCli(new Random().nextLong());
			cliComplexType.getTelCli().add(telCliComplexType);
			gerados++;
			return cliComplexType;
			
		}
		
		return null;
	}

}
