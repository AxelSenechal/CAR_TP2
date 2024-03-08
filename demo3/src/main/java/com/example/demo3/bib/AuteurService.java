package com.example.demo3.bib;


public interface AuteurService {
	
	void init();
	
	void ajouterAuteur(String nom, String prenom);
	
	Iterable<Auteur> getAllAuteurs();

	void retirerAuteur(String id);
	

}
