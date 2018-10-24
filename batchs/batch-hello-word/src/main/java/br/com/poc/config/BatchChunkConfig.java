package br.com.poc.config;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.poc.listenerjobs.ExemploChunkListener;
import br.com.poc.processor.ExemploItemProcessor;
import br.com.poc.reader.ExemploItemReader;
import br.com.poc.writer.ExemploItemWriter;

/**
 * 
 * @author raphael
 * Exemplo de configuração de Jobs para utilização de </br>
 *  chunk, itemReader, itemProcessor e itemWriter.
 */
@Configuration
public class BatchChunkConfig {

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	/************************** JOBS *********************************/
	@Bean
	public Job primeiroJob(ExemploChunkListener listener) {
		System.out.println("iniciaProcessamento - " + jobBuilderFactory);

		return jobBuilderFactory
					.get("primeiroJob")
					.incrementer(new RunIdIncrementer())
					.listener(listener)
					.flow(primeiroStep())
					.end()
					.build();
	}
	
	/*@Bean
	public Job segundoJob(ExemploChunkListener listener) {
		System.out.println("iniciaProcessamento - " + jobBuilderFactory);

		return jobBuilderFactory
					.get("segundoJob")
					.incrementer(new RunIdIncrementer())
					.listener(listener)
					.flow(controleCalculoStep1())
					.end()
					.build();
	}*/


	/************************** STEPS *********************************/
	@Bean
	public Step primeiroStep() {
		System.out.println("primeiroStep ");

		return stepBuilderFactory.get("primeiroStep")
				.<List<String>, String>chunk(1)/*
												 * Este método é muito
												 * importante, pois realiza a
												 * configuração da quantidade de
												 * processamento paralela que
												 * será realizada por vez
												 * (STEP), Os dois campos
												 * genéricos colocados também
												 * merecem bastante atenção pois
												 * são os Input/Output
												 * respectivamente, portanto, se
												 * não forem bem pensados e
												 * estiverem combinando com os
												 * ItemReader, ItemProcess e
												 * ItemWriter a aplicação não
												 * compila.
												 */
				.reader(new ExemploItemReader()) // Busca
																// todos
																// os
																// ControleCalculoComissao
																// Pendentes
				.processor(new ExemploItemProcessor()) // Processa um
																// por um
				.writer(new ExemploItemWriter()) // Persiste as
															// alterações no
															// Banco
				.build();
	}

	/*@Bean
	public Step segundoStep() {
		System.out.println("segundoStep ");

		return stepBuilderFactory.get("segundoStep")
				.<PoloComissaoBatchBO, Long>chunk(1)
				.reader(new EnfileiraRepassePolosComissaoIniciadosItemReader())
				.processor(
						new EnfileiraRepassePolosComissaoIniciadosItemProcessor())
				.writer(new EnfileiraPolosComissaoIniciadosItemWriter())
				.build();
	}*/

}
