package com.mea.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
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
	
	@Autowired
	private DataSource ds;
	
	
	//READER
	/*@Bean(name = "reader")
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
		fieldSetMapper.setTargetType(Employee.class);
		//Add LineTokenizer and FieldSetMapper object to LineMapper
		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		
		//Add LineMapper to reader
		reader.setLineMapper(lineMapper);
		
		//return the Reader object
		
		
		return reader;
	}*/
	
	//Using AnonymousClass+InstanceBlock
	//Using SubClass+InstanceBlock
	/*@Bean(name = "reader")
	public FlatFileItemReader<Employee> createReader(){
		
		FlatFileItemReader<Employee> reader=new FlatFileItemReader<Employee>() {{
				setResource(new ClassPathResource("Employee_Info.csv"));
				setLineMapper(new DefaultLineMapper<Employee>() {{
					setLineTokenizer(new DelimitedLineTokenizer() {{
						setDelimiter(",");
						setNames("empno","empname","address","salary");
					}});
					
					setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() {{
						setTargetType(Employee.class);
					}});
				}});
			}};
			return reader;
	}
	*/
	
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
	
	
	/*@Bean(name = "writer")
	public JdbcBatchItemWriter<Employee> createWriter(){
		//create object for JdbcBatchItemWriter
		JdbcBatchItemWriter<Employee> writer=new JdbcBatchItemWriter<Employee>();
		//set dataSource to writer object
		writer.setDataSource(ds);
		//set the sql query
		writer.setSql("INSERT INTO BATCH_EMPLOYEE VALUES(:empno,:empname,:address,:salary,:grossSalary,:netSalary)");
		//set model class obj to insert query param values
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
		
		
		return writer;
	}*/
	
	/*@Bean(name = "writer")
	public JdbcBatchItemWriter<Employee> createWriter(){
		
		JdbcBatchItemWriter<Employee> writer=new JdbcBatchItemWriter<Employee>() {{
			setDataSource(ds);
			setSql("INSERT INTO BATCH_EMPLOYEE VALUES(:empno,:empname,:address,:salary,:grossSalary,:netSalary)");
			setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
		}};
			
		return writer;
	}*/
	
	//Using Builder Class + Method Chaining
	@Bean(name = "writer")
	public JdbcBatchItemWriter<Employee> createWriter(){
		
		return new JdbcBatchItemWriterBuilder<Employee>()
				.dataSource(ds)
				.sql("INSERT INTO BATCH_EMPLOYEE VALUES(:empno,:empname,:address,:salary,:grossSalary,:netSalary)")
				.beanMapped() //create a bean property item sql parameter
				.build();
	}
	
	@Bean(name = "step1")
	public Step createStep1() {
		
		return stepFactory.get("step1")
				.<Employee,Employee>chunk(3)
				.reader(createReader())
				.writer(createWriter())
				.processor(processor)
				.build();
	}
	
	@Bean(name = "job1")
	public Job createJob() {
		
		return jobFactory.get("job1")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.start(createStep1())
				.build();
	}
}
