package com.example.demo3.bib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/bib")
public class AuteurController {
	
	@Autowired
	private AuteurService service;
	
	@GetMapping("/home")
	public String home(Model model) {
		Iterable<Auteur> auteurs = service.getAllAuteurs();
		model.addAttribute("auteurs",auteurs);
		return "/bib/home";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam String nom, @RequestParam String prenom) {
		service.ajouterAuteur(nom, prenom);
		return "redirect:/bib/home";
	}
	
	@PostMapping("/init")
	public String init() {
		service.init();
		return "redirect:/bib/home";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam String id) {
		System.out.print("Erasing id: "+id+"\n\n\n");
		service.retirerAuteur(id);
		return "redirect:/bib/home";

	}

}
