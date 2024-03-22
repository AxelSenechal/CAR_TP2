package com.example.demo3.agenda;



import org.springframework.data.repository.CrudRepository;

import com.example.demo3.account.Account;


public interface AgendaRepository extends CrudRepository<Agenda, Long> {

    Iterable<Agenda> findAllByAccount (Account account);
    


}
