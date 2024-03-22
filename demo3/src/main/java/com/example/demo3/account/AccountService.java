package com.example.demo3.account;


public interface AccountService {
	
	void init();
	
	void ajouterCompte(String nom, String prenom, String mail, String mdp);

	Account getAccount(String mail, String mdp);
	

}
