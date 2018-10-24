package br.com.poc.listenerjobs;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Service;

@Service("pocTaskletListener")
public class ExemploTaskletListener extends JobExecutionListenerSupport{

	@Override
	public void beforeJob(JobExecution jobExecution) {
		super.beforeJob(jobExecution);
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		super.afterJob(jobExecution);
	}
}
