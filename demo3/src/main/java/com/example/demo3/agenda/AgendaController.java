package com.example.demo3.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo3.account.Account;
import com.example.demo3.account.AccountService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/agenda")
public class AgendaController {

    /*
	@Autowired
	private AccountService serviceAccount;*/

	@Autowired
	private AgendaService serviceAgenda;



	@PostMapping("/create")
	public String create(HttpSession session, @RequestParam String nom, Model model) {
      
		serviceAgenda.addAgenda(nom, ((Account) session.getAttribute("account")).getMail());
        
		return "redirect:/agenda/dashboard";
    }

	@GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        model.addAttribute("agendas", serviceAgenda.getAgendas((Account) session.getAttribute("account")));
        return "/agenda/signedin";
    }

}
