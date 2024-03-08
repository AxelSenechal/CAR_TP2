package com.example.demo3.agenda;


public interface AccountService {
	
	void init();
	
	void ajouterCompte(String nom, String prenom, String mail, String mdp);

	Iterable<Account> getAccount(String mail, String mdp);
	

}
