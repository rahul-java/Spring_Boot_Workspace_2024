package com.mea.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class PurchaseMgmtServiceImpl implements IPurchaseMgmtService {

	@Autowired
	private JavaMailSender sender;
	
	@Override
	public String shopping(String[] items, Float[] prices, String fromMail, String[] toMail) throws Exception {
		//write the business logic
		float billAmt=0.0f;
		for(float p:prices) {
			billAmt+=p;
		}
		String msg=Arrays.toString(items)+" are purchased with prices "+Arrays.toString(prices)+" having billAmt : "+billAmt;
		String statusMsg=sendMailWithAttachment(msg, fromMail, toMail);
		return msg+"....."+statusMsg;
	}

	private String sendMailWithAttachment(String msg,String fromMail,String[] toMail) throws Exception
	{
		//create Mime msg obj empty mime msg obj
		MimeMessage message=sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message,true);
		helper.setFrom(fromMail);
		helper.setCc(toMail);
		helper.setSentDate(new Date());
		helper.setSubject("Open it to know it");
		helper.setText(msg);
		helper.addAttachment("home4.png", new ClassPathResource("home4.png"));
		sender.send(message);
		
		return "Mail Has Been Sent Successfully...";
	}
}
