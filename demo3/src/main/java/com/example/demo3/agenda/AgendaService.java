package com.example.demo3.agenda;

import java.util.List;

import com.example.demo3.account.Account;

public interface AgendaService {
	
	void init();
	
	void addAgenda(String nom, String mail);

	public List<Agenda> getAgendas(Account account);
	

}
