package com.mea.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.mea.listener.JobMonitoringListener;
import com.mea.model.Employee;
import com.mea.processor.EmployeeItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private StepBuilderFactory stepFactory;
	@Autowired
	private JobBuilderFactory jobFactory;
	@Autowired
	private JobMonitoringListener listener;
	@Autowired
	private EmployeeItemProcessor processor;
	
	//READER
	public FlatFileItemReader<Employee> createReader(){
		//create obj of FlatFileItemReader
		FlatFileItemReader<Employee> reader=new FlatFileItemReader<Employee>();
		//specify the location of file
		reader.setResource(new ClassPathResource("Employee_Info.csv"));
		//specify the LineMapper that gets each line by enter key
		DefaultLineMapper<Employee> lineMapper=new DefaultLineMapper<Employee>();
		//specify LineTokenizer to split line content into tokens based on the delimiter
		DelimitedLineTokenizer tokenizer=new DelimitedLineTokenizer();
		tokenizer.setDelimiter(",");
		tokenizer.setNames("empno","empname","address","salary");
		//set line tokens to model class object
		BeanWrapperFieldSetMapper<Employee> fieldSetMapper=new BeanWrapperFieldSetMapper<Employee>();
		
		//Add LineTokenizer and FieldSetMapper object to LineMapper
		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		
		//Add LineMapper to reader
		reader.setLineMapper(lineMapper);
		
		//return the Reader object
		
		
		return null;
	}
}
