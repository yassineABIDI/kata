package com.bank.kata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.kata.model.OperationsHistory;

public interface OperationHistoryRepository extends JpaRepository<OperationsHistory, Long>{

}
