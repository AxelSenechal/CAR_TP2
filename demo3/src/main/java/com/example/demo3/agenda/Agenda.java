package com.example.demo3.agenda;

import java.util.List;

import com.example.demo3.account.Account;
import com.example.demo3.event.Event;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Agenda {
	


	@Id
	@GeneratedValue
	private long id;
	private String nom;
	
	
	@ManyToOne
	@JoinColumn(name="mail")
	private Account account;

	@OneToMany(mappedBy = "agenda", cascade = jakarta.persistence.CascadeType.ALL)
	private List<Event> events;
	

	public List<Event> getEvents() {
		return events;
	}


	public void setEvents(List<Event> events) {
		this.events = events;
	}


	public Agenda() {
		
	}
	

	public Agenda(String nom, Account account) {
		
		
		this.nom = nom;
		this.account = account;
		if(!account.getAgendas().contains(this))
			account.getAgendas().add(this);
			
	}
	
	public Agenda(String nom, String mail) {
	
	
			this.nom = nom;
			this.account = null;
		}

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public Account getAccount() {
		return account;
	}



	public void setAccount(Account account) {
		this.account = account;
		if(!account.getAgendas().contains(this))
			account.getAgendas().add(this);	
	}



	
	
	
	

}
