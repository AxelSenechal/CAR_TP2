package com.example.demo3.event;

import org.hibernate.annotations.ManyToAny;

import com.example.demo3.agenda.Agenda;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Event {

    @Id
	@GeneratedValue
    long id_event;

    public long getId_event() {
        return id_event;
    }

    public void setId_event(long id_event) {
        this.id_event = id_event;
    }

    String libelle;
    String date;
    String horaire_debut;
    String horaire_fin;

    @ManyToOne
    @JoinColumn(name="id")
    Agenda agenda;

    public Event() {
        
    }

    public Event(String libelle, String date, String horaire_debut, String horaire_fin, Agenda agenda) {
        this.libelle = libelle;
        this.date = date;
        this.horaire_debut = horaire_debut;
        this.horaire_fin = horaire_fin;
        this.agenda = agenda;
        if(!agenda.getEvents().contains(this))
            agenda.getEvents().add(this);
    }



  
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getHoraire_debut() {
        return horaire_debut;
    }
    public void setHoraire_debut(String horaire_debut) {
        this.horaire_debut = horaire_debut;
    }
    public String getHoraire_fin() {
        return horaire_fin;
    }
    public void setHoraire_fin(String horaire_fin) {
        this.horaire_fin = horaire_fin;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
        if (!agenda.getEvents().contains(this))
            agenda.getEvents().add(this);
    }
    
}
