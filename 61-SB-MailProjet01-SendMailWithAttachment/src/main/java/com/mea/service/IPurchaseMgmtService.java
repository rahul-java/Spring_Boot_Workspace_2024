package com.mea.service;

public interface IPurchaseMgmtService {

	public String shopping(String[] items,Float[] prices,String fromMail,String[] toMail) throws Exception;
	
}
