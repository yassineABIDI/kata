package com.bank.kata.Services.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.kata.Services.OperationsHistoryService;
import com.bank.kata.model.OperationsHistory;
import com.bank.kata.repositories.OperationHistoryRepository;
import com.bank.kata.utils.OperationType;

@Service
public class OperationsHistoryServiceImpl implements OperationsHistoryService{
@Autowired
private OperationHistoryRepository operationHistRepository;
	@Override
	public List<OperationsHistory> findOperationHistory(Long idAccount) {
		return operationHistRepository.findAll();
	}
	@Override
	public void addOperation(Long idClient, Long idAccount,
			OperationType operationType,double montant, Date date) {
		OperationsHistory operation = new OperationsHistory();
		operation.setId_account(idAccount);
		operation.setId_client(idClient);
		operation.setOperationType(operationType);
		operation.setMontant(montant);
		operation.setOpration_date(date);
		operationHistRepository.save(operation);
		
	}

}
