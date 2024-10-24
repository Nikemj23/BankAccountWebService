package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer>{
	List<BankAccount> findByAcctOwnerCustomerId(String custId);

}
