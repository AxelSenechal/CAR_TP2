package com.example.demo3.event;

import java.util.Collections;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/agenda")
public class EventController {

    @Autowired
    private EventService serviceEvent;
    

    @PostMapping("/show_events_from_agenda")
    public String showEvents(@RequestParam long agenda_id,Model model){
        Iterable<Event> events = serviceEvent.getEventsByAgenda(agenda_id);
        model.addAttribute("events", events);
        return "redirect:/agenda/events_dashboard";

    }

    @PostMapping("/add_event")
    public String addEvent(@RequestParam String libelle, @RequestParam String date, @RequestParam String mail, @RequestParam String nomAgenda, @RequestParam String horaire_debut,
            @RequestParam String horaire_fin){
        serviceEvent.addEvent(libelle, date, mail, nomAgenda, horaire_debut, horaire_fin);
        return "/agenda/show_events_from_agenda";
    }
}
