package com.example.demo3.bib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuteurServiceImpl implements AuteurService {

	@Autowired
	private AuteurRepository repo;

	@Override
	public void init() {
		repo.save(new Auteur("Hugo", "Victor"));
		repo.save(new Auteur("Jules", "Verne"));

	}

	@Override
	public void ajouterAuteur(String nom, String prenom) {
		repo.save(new Auteur(nom, prenom));
	}

	@Override
	public Iterable<Auteur> getAllAuteurs() {

		return repo.findAll();
	}

	@Override
	public void retirerAuteur(String id) {
		System.out.println("--------------------------------\nID: "+id+"--------------------------------\n");
		repo.deleteById((long) Integer.parseInt(id));
		
	}
	
	

}
