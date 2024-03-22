package com.example.demo3.event;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/agenda")
public class EventController {

    @Autowired
    private EventService serviceEvent;
    
    @PostMapping("/agenda_save")
    public String saveAgenda(@RequestParam long id_agenda,@RequestParam String nom_agenda , HttpSession session){
       session.setAttribute("id_agenda", id_agenda);
       session.setAttribute("nom_agenda", nom_agenda);
       
        return "redirect:/agenda/show_events_from_agenda";
    }


    @GetMapping("/show_events_from_agenda")
    public String showEvents(HttpSession session, Model model){
        model.addAttribute("events",  serviceEvent.getEventsByAgenda((long) session.getAttribute("id_agenda")));
        return "/agenda/events_dashboard";

    }



    @PostMapping("/add_event")
    public String addEvent(@RequestParam String libelle, @RequestParam String date, @RequestParam long id_agenda, @RequestParam String horaire_debut,
            @RequestParam String horaire_fin){
        serviceEvent.addEvent(libelle, date, id_agenda, horaire_debut, horaire_fin);
        return "redirect:/agenda/show_events_from_agenda";
    }

    @PostMapping("/delete_event")
    public String deleteEvent(@RequestParam long id_event){
        serviceEvent.deleteEvent(id_event);
        return "redirect:/agenda/show_events_from_agenda";
    }

    @GetMapping("/print")
    public String print(Model model, HttpSession session){
        model.addAttribute("events",  serviceEvent.getEventsByAgenda((long) session.getAttribute("id_agenda")));

        return "/agenda/events_print_page";
    }
}
