package com.bank.kata.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bank.kata.utils.OperationType;

@Entity
@Table(name ="OPERATION_HIST")
public class OperationsHistory {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long id;
@Column(name ="OPERATION_TYPE")
private OperationType operationType;
@Column(name ="ID_CLIENT")
private Long id_client;
@Column(name ="ACCOUNT")
private Long id_account;
@Column(name ="MONTANT")
private double montant;
@Column(name ="OPERATION_DATE")
private Date opration_date;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public OperationType getOperationType() {
	return operationType;
}
public void setOperationType(OperationType operationType) {
	this.operationType = operationType;
}
public Long getId_client() {
	return id_client;
}
public void setId_client(Long id_client) {
	this.id_client = id_client;
}
public Long getId_account() {
	return id_account;
}
public void setId_account(Long id_account) {
	this.id_account = id_account;
}
public Date getOpration_date() {
	return opration_date;
}
public void setOpration_date(Date opration_date) {
	this.opration_date = opration_date;
}
public double getMontant() {
	return montant;
}
public void setMontant(double montant) {
	this.montant = montant;
}

}
