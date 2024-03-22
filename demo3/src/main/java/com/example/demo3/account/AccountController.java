package com.example.demo3.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/agenda")
public class AccountController {

	@Autowired
	private AccountService serviceAccount;

	


	@GetMapping("/home")
	public String home(Model model) {

		return "/agenda/home";
	}

	@PostMapping("/add")
	public String add(@RequestParam String nom, @RequestParam String prenom, @RequestParam String mail,
			@RequestParam String mdp) {
				serviceAccount.ajouterCompte(prenom, prenom, mail, mdp);
		return "redirect:/agenda/home";
	}

	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam String mail, @RequestParam String mdp) {
		Account account = serviceAccount.getAccount(mail, mdp);
		if (account != null) {
			session.setAttribute("account", account);
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
