package com.bank.kata.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.kata.Services.AccountService;
import com.bank.kata.Services.OperationsHistoryService;
import com.bank.kata.model.OperationsHistory;
import com.bank.kata.model.Transaction;
import com.bank.kata.utils.OperationType;

@RestController
public class AccountRestController {

	@Autowired
	private OperationsHistoryService operationHistoryService;
	
	@Autowired
	private AccountService accountService;
	
        
	@GetMapping(value="/api/operationsHistory/{idAccount}")
	 public List<OperationsHistory> getOperationsHository(@PathVariable Long idAccount) {
	  return   operationHistoryService.findOperationHistory(idAccount);
	  
	 }
	
	@PostMapping("/api/retrieve")
	 public void retrieveAccount(Transaction transaction){
		
		accountService.retrieve(transaction);
		operationHistoryService.addOperation(transaction.getIdClient(), transaction.getIdAccount(),  OperationType.RETRIEVE,transaction.getMontant(), new Date());

	 }

	
	@PostMapping("/api/deposit")
	 public void DepositAccount(Transaction transaction){
		
		accountService.makeDeposit(transaction);
		operationHistoryService.addOperation(transaction.getIdClient(), transaction.getIdAccount(),  OperationType.DEPOSI,transaction.getMontant(), new Date());

	 }
}
