package com.mea.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.mea.listener.JobMonitoringListener;
import com.mea.model.ExamResult;
import com.mea.processor.ExamResultItemProcessor;

@Configuration
public class BatchConfig {

	@Autowired
	private JobMonitoringListener listener;
	@Autowired
	private DataSource ds;
	@Autowired
	private ExamResultItemProcessor processor;
	
	
	@Bean
	public JdbcCursorItemReader<ExamResult> createReader(){
		
		return new JdbcCursorItemReaderBuilder<ExamResult>()
				.name("jdbc-reader")
				.dataSource(ds)
				.sql("SELECT ID,DOB,PERCENTAGE,SEMESTER FROM EXAM_RESULT")
				.beanRowMapper(ExamResult.class)
				.build();
	}
	
	
	@Bean
	public FlatFileItemWriter<ExamResult> createWriter()
	{
		return new FlatFileItemWriterBuilder<ExamResult>()
				.name("file-writer")
				.resource(new FileSystemResource("TopBrains.csv"))
				.lineSeparator("\r\n")
				.delimited().delimiter(",")
				.names("id","dob","percentage","semester")
				.build();
	}
	
	@Bean(name = "step1")
	public Step createStep1(JobRepository jobRepository,PlatformTransactionManager transactionManager) {
		return new StepBuilder("step1",jobRepository)
				.<ExamResult,ExamResult>chunk(3, transactionManager)
				.reader(createReader())
				.processor(processor)
				.writer(createWriter())
				.build();
				
	}
	
	@Bean(name = "job1")
	public Job createJob(JobRepository jobRepository,Step step1) {
		return new JobBuilder("job1",jobRepository)
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.start(step1)
				.build();
	}
}
