package com.mea.processor;

import org.springframework.batch.item.ItemProcessor;

import com.mea.model.ExamResult;

public class ExamResultItemProcessor implements ItemProcessor<ExamResult, ExamResult> {

	@Override
	public ExamResult process(ExamResult item) throws Exception {
		if(item.getPercentage()>=90.0f)
			return item;
		return null;
	}

}
