package com.example.demo3.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository repoAccounts;

	@Override
	public void init() {
		Account a = new Account("Hugo", "Dupont", "a@a.a", "mdp");
		repoAccounts.save(a);
		
	}

	@Override
	public void ajouterCompte(String nom, String prenom, String mail, String mdp) {
		repoAccounts.save(new Account(nom, prenom, mail, mdp));
	}

	@Override
	public Account getAccount(String mail, String mdp){
		
		try {
		Account a = repoAccounts.findById(mail).get();
		if(a.getMdp().equals(mdp)) return a;
		return null;
			
		}
		catch (Exception e) {
			return null;
		}
		
	}

	/*
	 * @Override public Iterable<Personne> getAllAuteurs() {
	 * 
	 * return repo.findAll(); }
	 * 
	 * @Override public void retirerAuteur(String id) {
	 * System.out.println("--------------------------------\nID: "+id+
	 * "--------------------------------\n"); repo.deleteById((long)
	 * Integer.parseInt(id));
	 * 
	 * }
	 */

}
