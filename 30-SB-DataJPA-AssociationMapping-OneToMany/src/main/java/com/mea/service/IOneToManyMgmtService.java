package com.mea.service;

public interface IOneToManyMgmtService {

	public String saveDataUsingParentToChild();
	public String saveDataUsingChildToParent();
	public void loadDataUsingParent();
	
	public String removeDataByParent(int pid);
	public String removeAllChildsOfTheParent(int pid);
	
	public String addNewChildToExistingParent(int pid);
	
}
