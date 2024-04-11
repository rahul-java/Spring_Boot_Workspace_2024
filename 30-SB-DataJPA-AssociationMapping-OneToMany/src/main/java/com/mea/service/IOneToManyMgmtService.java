package com.mea.service;

public interface IOneToManyMgmtService {

	public String saveDataUsingParentToChild();
	public String saveDataUsingChildToParent();
	public void loadDataUsingParent();
}
