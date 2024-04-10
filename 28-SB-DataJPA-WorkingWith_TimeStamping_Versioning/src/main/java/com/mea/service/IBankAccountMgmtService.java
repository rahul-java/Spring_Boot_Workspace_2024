package com.mea.service;

import com.mea.entity.BankAccount;

public interface IBankAccountMgmtService {

	public String registerBankAccount(BankAccount account);
	public String withdrawAmount(Long acno,Double amount);
}
