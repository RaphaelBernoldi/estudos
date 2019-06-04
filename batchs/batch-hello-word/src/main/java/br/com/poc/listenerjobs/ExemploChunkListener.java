package br.com.poc.listenerjobs;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Component
public class ExemploChunkListener extends JobExecutionListenerSupport{
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("afterJob - " + jobExecution.getExitStatus());
		super.afterJob(jobExecution);
	}
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("beforeJob - " + jobExecution.getExitStatus());
		super.beforeJob(jobExecution);
	}
	

}
