package com.example.demo3.agenda;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Agenda {
	




	private long id;
	private String name;
	
	@ManyToOne
	(cascade=CascadeType.ALL)
	private Account account;
	

	public Agenda() {
		super();
	}
	
	public Agenda(String name) {
		super();
		this.name = name;
		this.account = null;
	}
	
	public Agenda(String name, Account account) {
		super();
		this.id=id;
		this.name = name;
		this.account = account;
	}
	

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Account getAccount() {
		return account;
	}



	public void setAccount(Account account) {
		this.account = account;
	}



	
	
	
	

}
