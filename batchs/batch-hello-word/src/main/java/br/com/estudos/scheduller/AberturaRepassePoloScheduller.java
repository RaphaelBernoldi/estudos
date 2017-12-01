package br.edu.cruzeirodosul.scheduller;

import javax.annotation.Resource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AberturaRepassePoloScheduller implements Scheduller {

	@Autowired
	private JobLauncher jobLauncher;

	@Resource(name = "iniciaProcessamento")
	private Job job;

	private JobExecution execution;

	@Override
	@Scheduled(cron = "*/10 * * * * ?")
	public void run() {
		System.out.println("AberturaRepassePoloScheduller.run()");
		try {

			execution = jobLauncher.run(job, new JobParameters());
			System.out.println("Execution status: " + execution.getStatus());

		} catch (JobExecutionAlreadyRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobRestartException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
