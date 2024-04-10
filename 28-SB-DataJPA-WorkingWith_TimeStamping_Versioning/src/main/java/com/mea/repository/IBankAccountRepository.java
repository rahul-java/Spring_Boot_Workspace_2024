package com.mea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mea.entity.BankAccount;

public interface IBankAccountRepository extends JpaRepository<BankAccount, Long> {

}
