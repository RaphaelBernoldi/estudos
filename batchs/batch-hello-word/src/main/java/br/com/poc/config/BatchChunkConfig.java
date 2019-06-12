package br.com.poc.config;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.poc.listenerjobs.ExemploChunkListener;
import br.com.poc.model.acpo021.v1.CliComplexType;
import br.com.poc.model.dto.ClientToProcDTO;
import br.com.poc.processor.CadPosItemProcessor;
import br.com.poc.processor.ExemploItemProcessor;
import br.com.poc.processor.GeraArquivoItemProcessor;
import br.com.poc.reader.CadPosItemReader;
import br.com.poc.reader.ExemploItemReader;
import br.com.poc.reader.GeraArquivoItemReader;
import br.com.poc.writer.CadPosItemWriter;
import br.com.poc.writer.ExemploItemWriter;
import br.com.poc.writer.GeraArquivoItemWriter;

/**
 * 
 * @author raphael Exemplo de configuração de Jobs para utilização de </br>
 *         chunk, itemReader, itemProcessor e itemWriter.
 */
@Configuration
public class BatchChunkConfig {

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private JobRepositoryConfig jobRepositoryConfig;
	

	@Bean(name="jobLauncherChunk")
	public JobLauncher jobLauncher() {
			
			try {
				SimpleJobLauncher launcher = new SimpleJobLauncher();
				launcher.setJobRepository(jobRepositoryConfig.criaJobRepository());
				return launcher;
				
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		

	/************************** JOBS *********************************/
	@Bean
	public Job primeiroJob(ExemploChunkListener listener) {
		System.out.println("iniciaProcessamento  - " + jobBuilderFactory);

		return jobBuilderFactory
				.get("primeiroJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(primeiroStep())
				.end()
				.build();
	}
	
	@Bean
	public Job jobCadastroPositivo(ExemploChunkListener listener) throws Exception {
		System.out.println("iniciaProcessamento  - " + jobBuilderFactory);

		return jobBuilderFactory
				.get("jobCadastroPositivo")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(stepMigrateDataCadPos())
				.end()
				.build();
	}
	
	@Bean
	public Job jobGeraArquivoTeste(ExemploChunkListener listener) throws Exception {
		System.out.println("iniciaProcessamento  - " + jobBuilderFactory);

		return jobBuilderFactory
				.get("jobGeraArquivoTeste")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(stepGeraArquivoTeste())
				.end()
				.build();
	}

	/************************** STEPS  *********************************/
	@Bean
	public Step primeiroStep() {
		System.out.println("primeiroStep ");

		return stepBuilderFactory.get("primeiroStep").<List<String>, String>chunk(1)/*
																					 * Este método é muito importante,
																					 * pois realiza a configuração da
																					 * quantidade de processamento
																					 * paralela que será realizada por
																					 * vez (STEP), Os dois campos
																					 * genéricos colocados também
																					 * merecem bastante atenção pois são
																					 * os Input/Output respectivamente,
																					 * portanto, se não forem bem
																					 * pensados e estiverem combinando
																					 * com os ItemReader, ItemProcess e
																					 * ItemWriter a aplicação não
																					 * compila.
																					 */
				.reader(new ExemploItemReader()) // Busca todos os ControleCalculoComissao Pendentes
				.processor(new ExemploItemProcessor()) // Processa um por um
				.writer(new ExemploItemWriter()) // Persiste as alterações no Banco
				.build();
	}
	
	@Bean
	public Step stepMigrateDataCadPos() throws Exception {
		System.out.println("stepMigrateDataCadPos");

		return stepBuilderFactory.get("stepMigrateDataCadPos").<ClientToProcDTO, ClientToProcDTO>chunk(100)
				.reader(new CadPosItemReader())
				.processor(new CadPosItemProcessor()) 
				.writer(new CadPosItemWriter()) 
				.build();
	}
	
	@Bean
	public Step stepGeraArquivoTeste() throws Exception {
		System.out.println("stepGeraArquivoTeste");

		return stepBuilderFactory.get("stepGeraArquivoTeste").<CliComplexType, CliComplexType>chunk(1000)
				.reader(new GeraArquivoItemReader())
				.processor(new GeraArquivoItemProcessor()) 
				.writer(new GeraArquivoItemWriter()) 
				.build();
	}
	
	
}
