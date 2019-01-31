package com.bank.kata.Services.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.kata.Services.AccountService;
import com.bank.kata.Services.OperationsHistoryService;
import com.bank.kata.model.Account;
import com.bank.kata.model.Transaction;
import com.bank.kata.repositories.AccountRepository;


@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private OperationsHistoryService operationHistoryService;

	@Override
	public double makeDeposit(Transaction transaction) {

		Optional<Account> account = accountRepository.findById(transaction.getIdAccount());
		if(account.isPresent()){
			double solde = account.get().getSolde();
			account.get().setSolde(solde + transaction.getMontant());
		}
		accountRepository.save(account.get());
			return account.get().getSolde();	
	}

	@Override
	public double retrieve(Transaction transaction) {
		Optional<Account> account = accountRepository.findById(transaction.getIdAccount());
		if(account.isPresent()){
			double solde = account.get().getSolde();
			if(transaction.getMontant()<=solde){
				account.get().setSolde(solde - transaction.getMontant());
				accountRepository.save(account.get());
			}
		}
		
		return account.get().getSolde();	
	}

}
