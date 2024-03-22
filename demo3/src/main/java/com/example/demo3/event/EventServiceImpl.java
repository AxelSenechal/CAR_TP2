package com.example.demo3.event;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo3.account.Account;
import com.example.demo3.account.AccountRepository;
import com.example.demo3.agenda.Agenda;
import com.example.demo3.agenda.AgendaRepository;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    private EventRepository repoEvents;

    @Autowired
    private AgendaRepository repoAgendas;

    @Autowired
    private AccountRepository repoAccounts;

    @Override
    public void init() {

    }

    @Override
    public void addEvent(String libelle, String date, String mail, String nomAgenda, String horaire_debut,
            String horaire_fin) {
        Account a = repoAccounts.findById(mail).get();
        ArrayList<Agenda> agendas = (ArrayList<Agenda>) repoAgendas.findAllByAccount(a);
        for (Agenda agenda : agendas) {
            if(agenda.getNom().equals(nomAgenda)){
                Event e = new Event(libelle, date, horaire_debut, horaire_fin, agenda);
                repoEvents.save(e);
                repoAgendas.save(agenda);
            }
        }
    
    
    }

    @Override
    public void deleteEvent(long idEvent) {
        repoEvents.deleteById(idEvent);
    }

    @Override
    public List<Event> getEventsByAgenda(long idAgenda) {
        Agenda a = repoAgendas.findById(idAgenda).get();
        return (List<Event>) repoEvents.findAllByAgenda(a);
    }
    
}
