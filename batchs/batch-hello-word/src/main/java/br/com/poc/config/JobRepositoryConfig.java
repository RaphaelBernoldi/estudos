package br.com.poc.config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.core.repository.support.SimpleJobRepository;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobRepositoryConfig extends JobRepositoryFactoryBean {

	@Autowired
	private DataSource dataSource;
	
	
	public DataSource getDataSource() {
		return getDataSource();
	}

	@PostConstruct
	private void init() throws Exception {
		setDataSource(dataSource);
		setTransactionManager(new ResourcelessTransactionManager());
		afterPropertiesSet();
		
	}
	
	public JobRepository criaJobRepository() throws Exception {
		return new SimpleJobRepository(createJobInstanceDao(), createJobExecutionDao(), createStepExecutionDao(), createExecutionContextDao());
	}
	
}
