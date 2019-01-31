package com.bank.kata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.kata.model.Account;


public interface AccountRepository extends JpaRepository<Account, Long>{

}
