package com.mea.config;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

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
}
