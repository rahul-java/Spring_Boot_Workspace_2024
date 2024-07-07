package com.mea.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.mea.listener.JobMonitoringListener;
import com.mea.model.Employee;
import com.mea.processor.EmployeeItemProcessor;
import com.mea.repository.IEmployeeRepo;

@Configuration
//@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobMonitoringListener listener;
	@Autowired
	private EmployeeItemProcessor processor;
	
	@Autowired
	private DataSource ds;
	@Autowired
	private IEmployeeRepo empRepo;
	
	//Using Builder Class + Method Chaining
	@Bean(name = "reader")
	public FlatFileItemReader<Employee> createReader(){
			return new FlatFileItemReaderBuilder<Employee>()
					.name("file-reader")
					.resource(new ClassPathResource("Employee_Info.csv"))
					.delimited() //bydefault it takes ',' as delimiter
					.names("empno","empname","address","salary")
					.targetType(Employee.class)
					.build();
	}
	
	
	//Using Builder Class + Method Chaining
	@Bean(name = "writer")
	public RepositoryItemWriter<Employee> createWriter(){
		
		return new RepositoryItemWriterBuilder<Employee>()
				.repository(empRepo)
				.methodName("save")
				.build();
	}
	
	@Bean(name = "step1")
	public Step createStep1(JobRepository jobRepository, PlatformTransactionManager transactionManager ) {
		
		return new StepBuilder("step1", jobRepository)
				.<Employee,Employee>chunk(3,transactionManager)
				.reader(createReader())
				.writer(createWriter())
				.processor(processor)
				.build();
	}
	
	@Bean(name = "job1")
	public Job createJob(JobRepository jobRepository, Step step1) {
		
		return new JobBuilder("job1", jobRepository)
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.start(step1)
				.build();
	}
}
