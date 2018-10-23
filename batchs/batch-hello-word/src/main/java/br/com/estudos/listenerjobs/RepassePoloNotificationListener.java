package br.com.estudos.listenerjobs;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Component
public class RepassePoloNotificationListener
		extends JobExecutionListenerSupport {

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("RepassePoloNotificationListener.afterJob");
	}

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("RepassePoloNotificationListener.beforeJob");
	}

}
