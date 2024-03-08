package com.example.demo3.agenda;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Account {
	

	

	private String nom;
	private String prenom;
	private String mail;
	private String mdp;
	
	@OneToMany
	(cascade=CascadeType.ALL)
	private List<Agenda> agendas;
	
	
	public Account() {
		super();

	}
	public Account(String nom, String prenom, String mail, String mdp, List<Agenda> agendas) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
		this.agendas = agendas;
	}
	
	public Account(String nom, String prenom,String mail, String mdp) {
		super();
		
		this.nom = nom;
		this.prenom = prenom;
		this.mdp = mdp;
		this.mail = mail;
		
	}

	@Id
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public List<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}


	
	

}
