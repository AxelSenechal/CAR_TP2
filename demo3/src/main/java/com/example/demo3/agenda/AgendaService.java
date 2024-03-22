package com.example.demo3.agenda;



public interface AgendaService {
	
	void init();
	
	void addAgenda(String nom, String mail);

	Agenda getAgenda(Long id);
	

}
