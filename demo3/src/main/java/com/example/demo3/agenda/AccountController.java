package com.example.demo3.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/agenda")
public class AccountController {

	@Autowired
	private AccountService service;

	@GetMapping("/home")
	public String home(Model model) {

		return "/agenda/home";
	}

	@PostMapping("/add")
	public String add(@RequestParam String nom, @RequestParam String prenom, @RequestParam String mail,
			@RequestParam String mdp) {
		service.ajouterCompte(prenom, prenom, mail, mdp);
		return "redirect:/agenda/home";
	}

	@PostMapping("/login")
	public String login(Model model, @RequestParam String mail, @RequestParam String mdp) {
		Account a = service.getAccount(mail, mdp);
		if (a != null) {
			model.addAttribute("account", a);
			return "/agenda/signedin";
		}

		return "redirect:/agenda/home";
	}

	/*
	 * @GetMapping("/home") public String home(Model model) { Iterable<Account>
	 * auteurs = service.getAllAuteurs(); model.addAttribute("auteurs",auteurs);
	 * return "/bib/home"; }
	 * 
	 * @PostMapping("/add") public String add(@RequestParam String
	 * nom, @RequestParam String prenom) { service.ajouterAuteur(nom, prenom);
	 * return "redirect:/bib/home"; }
	 * 
	 * @PostMapping("/init") public String init() { service.init(); return
	 * "redirect:/bib/home"; }
	 * 
	 * @PostMapping("/remove") public String remove(@RequestParam String id) {
	 * System.out.print("Erasing id: "+id+"\n\n\n"); service.retirerAuteur(id);
	 * return "redirect:/bib/home";
	 * 
	 * }
	 */

}
