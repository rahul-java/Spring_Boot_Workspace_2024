package com.mea.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component("bookReader")
public class BookItemReader implements ItemReader<String> {

	private String[] books=new String[] {"ThinkingInJava","EffectiveJava","HeadFirstJava","BlackBookOfJava","CompleteReferenceOfJava"};
	private int count=0;
	
	
	public BookItemReader() {
		System.out.println("BookItemReader.BookItemReader() :: 0-ParamConstructor");
	}
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if(count<books.length)
		{
			return books[count++];
		}
		return null;
	}

}
