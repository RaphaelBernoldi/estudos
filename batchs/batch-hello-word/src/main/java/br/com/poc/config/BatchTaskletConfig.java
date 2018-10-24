package br.com.poc.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.poc.listenerjobs.ExemploTaskletListener;
import br.com.poc.tasket.ExemploTasklet;

/**
 * 
 * @author raphael
 * Exemplo de configuração de Jobs para utilização de tasklets
 */
@Configuration
public class BatchTaskletConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	@Qualifier("pocTaskletListener")
	private JobExecutionListenerSupport pocTaskletListener;
	
	/******** config job ********/
	@Bean
	public Job jobPocTasklet() {
		return jobBuilderFactory
				.get("jobPocTasklet")
				.listener(pocTaskletListener)
				.incrementer(new RunIdIncrementer())
				.flow(stepPocTasklet())
				.end()
				.build();
	}

	/******** config step ********/
	@Bean
	public Step stepPocTasklet() {
		return stepBuilderFactory
				.get("stepPocTasklet")
				.tasklet(exemploTasklet())
				.build();
	}

	/******** config tasklet ********/
	@Bean
	public Tasklet exemploTasklet() {
		 return new ExemploTasklet();
	}
	
	/******** config job repository ********/
	@Bean
	public JobLauncher jobLauncher(JobRepository jobRepository) {
		SimpleJobLauncher launcher = new SimpleJobLauncher();
		launcher.setJobRepository(jobRepository);
		return launcher;
	}
	
	@Bean
	public JobRepository jobRepository(MapJobRepositoryFactoryBean factory) throws Exception {
		return factory.getObject();
	}
	
	/******** config job listener ********/
	@Bean
	public JobExecutionListenerSupport listenerPocTasklet() {
		return new ExemploTaskletListener();
	}

}
