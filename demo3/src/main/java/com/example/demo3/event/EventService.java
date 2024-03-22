package com.example.demo3.event;

import java.util.List;

import com.example.demo3.account.Account;

public interface EventService {
	
	void init();
	
	void addEvent(String libelle , String date, long id_agenda, String horaire_debut, String horaire_fin);
	
    List<Event> getEventsByAgenda (long idAgenda);

    void deleteEvent(long idEvent);

}
