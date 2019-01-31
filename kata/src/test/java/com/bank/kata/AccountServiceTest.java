package com.bank.kata;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.kata.Services.OperationsHistoryService;
import com.bank.kata.Services.Impl.AccountServiceImpl;
import com.bank.kata.model.Account;
import com.bank.kata.model.Client;
import com.bank.kata.model.Transaction;
import com.bank.kata.repositories.AccountRepository;







import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

	
	@Mock
	AccountRepository accountRepository;
	
	@Mock
	OperationsHistoryService operationHistoryService;

	@InjectMocks
	AccountServiceImpl businessImpl;
	
	@Test
	public void testMakeDeposit(){
		Transaction transaction = new Transaction();
		transaction.setIdAccount(1L);
		transaction.setIdClient(11L);
		transaction.setMontant(250);
		
		Account account = new Account();
		account.setClient(new Client());
		account.setId(1L);
		account.setSolde(5750);
		
		when(accountRepository.findById(1L)).thenReturn(Optional.of(account));
		
		assertEquals(6000, businessImpl.makeDeposit(transaction),0);

	}
	
	
	@Test
	public void testRetrieve(){
		Transaction transaction1 = new Transaction();
		transaction1.setIdAccount(1L);
		transaction1.setIdClient(11L);
		transaction1.setMontant(100);
		
		Transaction transaction2 = new Transaction();
		transaction2.setIdAccount(1L);
		transaction2.setIdClient(11L);
		transaction2.setMontant(50);
		
		Transaction transaction3 = new Transaction();
		transaction3.setIdAccount(1L);
		transaction3.setIdClient(11L);
		transaction3.setMontant(100);
		
		Account account = new Account();
		account.setClient(new Client());
		account.setId(1L);
		account.setSolde(150);
		
	
		
		when(accountRepository.findById(1L)).thenReturn(Optional.of(account));
		//solde account = 150  ==> retrieve t1  150-100 =>solde account = 50
		assertEquals(50, businessImpl.retrieve(transaction1),0);
		//solde account = 50  ==> retrieve t2  50-50  => solde account = 0
		assertEquals(0, businessImpl.retrieve(transaction2),0);
		// solde account = 0 ==> retrive t3 0-150  => solde account = 0
		assertEquals(0, businessImpl.retrieve(transaction3),0);

	}
	
}
