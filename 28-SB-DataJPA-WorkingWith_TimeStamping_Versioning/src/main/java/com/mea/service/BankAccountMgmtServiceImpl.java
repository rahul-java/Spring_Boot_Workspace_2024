package com.mea.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mea.entity.BankAccount;
import com.mea.repository.IBankAccountRepository;

@Service("bankService")
public class BankAccountMgmtServiceImpl implements IBankAccountMgmtService {

	@Autowired
	private IBankAccountRepository bankRepo;
	@Override
	public String registerBankAccount(BankAccount account) {
		BankAccount savedBankAccount = bankRepo.save(account);
		return "Your Bank Account is opened with account no : "+savedBankAccount.getAcNo();
	}
	
	
	@Override
	public String withdrawAmount(Long acno, Double amount) {
		Optional<BankAccount> optional = bankRepo.findById(acno);
		if(optional.isPresent())
		{
			BankAccount account = optional.get();
			account.setBalance(account.getBalance()-amount);
			BankAccount updatedAccount = bankRepo.save(account);
			return "Bank Account is loaded and updated at "+updatedAccount.getLastAccessedOn()
			   +" for "+updatedAccount.getUpdationCount()+" times. Ava.Bal. : "+updatedAccount.getBalance();
		}
		return "Bank Account Does'nt Exist";
	}

}
