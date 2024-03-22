package com.example.demo3.event;
import org.springframework.data.repository.CrudRepository;

import com.example.demo3.agenda.Agenda;


public interface EventRepository extends CrudRepository<Event, Long> {

    Iterable<Event> findAllByAgenda (Agenda agenda);
    
}
