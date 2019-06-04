package br.com.poc.scheduller;

import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ExemploChunkScheduller implements Scheduller {

	@Autowired
	@Qualifier("jobLauncherChunk")
	private JobLauncher jobLauncher;

	@Autowired
	@Resource(name = "primeiroJob")
	private Job job;
	
	private JobExecution execution;
	
	@Override
	@Scheduled(cron = "*/10 * * * * ?")
	public void run() {
		System.out.println("ExemploChunkScheduller.run()");
		
		try {
			
			JobParameters param = new JobParametersBuilder()
										.addLong("JobID",new Random().nextLong())
										.addString("JobName", job.getName())
										.addDate("dateExecution", new Date())
										.toJobParameters();
			
			execution = jobLauncher.run(job, param);
			
			System.out.println("Execution status: " + execution.getStatus());
			
			
		} catch (JobExecutionAlreadyRunningException e) {
			e.printStackTrace();
			
		} catch (JobRestartException e) {
			e.printStackTrace();
			
		} catch (JobInstanceAlreadyCompleteException e) {
			e.printStackTrace();
			
		} catch (JobParametersInvalidException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
