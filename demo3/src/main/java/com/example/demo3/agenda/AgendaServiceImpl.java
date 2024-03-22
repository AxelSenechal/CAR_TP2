package com.example.demo3.agenda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo3.account.Account;
import com.example.demo3.account.AccountRepository;

@Service
public class AgendaServiceImpl implements AgendaService {

    @Autowired
	private AgendaRepository repoAgendas;

    @Autowired
    private AccountRepository repoAccounts;

	@Override
	public void init() {
		
		
	}

	@Override
	public void addAgenda(String nom, String mail) {
        Account a = repoAccounts.findById(mail).get();
        Agenda ag = new Agenda(nom,a);
        ag.setAccount(a);
        repoAgendas.save(ag);
        repoAccounts.save(a);   
    }

	@Override
	public List<Agenda> getAgendas(Account a) {
       
        return (List<Agenda>) repoAgendas.findAllByAccount(a);
    
    }




   
}