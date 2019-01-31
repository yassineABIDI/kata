package com.bank.kata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.kata.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
