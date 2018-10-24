package br.com.poc.listenerjobs;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Component
public class ExemploChunkListener extends JobExecutionListenerSupport{
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		super.afterJob(jobExecution);
	}
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		super.beforeJob(jobExecution);
	}
	

}
