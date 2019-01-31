package com.bank.kata.Services;

import java.util.Date;
import java.util.List;

import com.bank.kata.model.OperationsHistory;
import com.bank.kata.utils.OperationType;


public interface OperationsHistoryService {
	
	public List<OperationsHistory> findOperationHistory(Long idAccount);
	public void addOperation(Long idClient, Long idAccount, OperationType operationType ,double montant, Date date);
}
