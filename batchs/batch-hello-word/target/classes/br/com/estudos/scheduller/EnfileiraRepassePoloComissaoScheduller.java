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
public class EnfileiraRepassePoloComissaoScheduller implements Scheduller {

	@Autowired
	private JobLauncher jobLauncher;

	@Resource(name = "enfileiraControlesPoloComissao")
	private Job job;

	private JobExecution execution;

	@Scheduled(cron = "*/10 * * * * ?")
	@Override
	public void run() {
		System.out.println("EnfileiraRepassePoloComissaoScheduller.run()");

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
