package com.mea.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("bookProcessor")
public class BookItemProcessor implements ItemProcessor<String, String> {

	
	public BookItemProcessor() {
		System.out.println("BookItemProcessor.BookItemProcessor() :: 0-ParamConstructor");
	}
	@Override
	public String process(String item) throws Exception {
		System.out.println("BookItemProcessor.process()");
		
		String bookWithAuthor=null;
		if(item.equalsIgnoreCase("ThinkingInJava"))
			bookWithAuthor=item+" By Bruce Eckel";
		else if (item.equalsIgnoreCase("EffectiveJava"))
			bookWithAuthor=item+" By Joshua Bloch";
		else if (item.equalsIgnoreCase("BlackBookOfJava"))
			bookWithAuthor=item+" By RNR";
		else if (item.equalsIgnoreCase("HeadFirstJava"))
			bookWithAuthor=item+" By Kathy Sierra";
		else if (item.equalsIgnoreCase("CompleteReferenceOfJava"))
			bookWithAuthor=item+" By Herbat Schield";
		else
		    bookWithAuthor=null;
		
		return bookWithAuthor;
	}

}
