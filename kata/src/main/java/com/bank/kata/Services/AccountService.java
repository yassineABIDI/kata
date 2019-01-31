package com.bank.kata.Services;

import com.bank.kata.model.Transaction;

public interface AccountService {

	public double makeDeposit(Transaction transaction);
	
	public double retrieve(Transaction transaction);
}
