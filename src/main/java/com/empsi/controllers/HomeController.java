package com.empsi.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.dao.PaiementRepository;
import com.empsi.entities.Paiement;

@RestController
public class HomeController {

	@Autowired
	public PaiementRepository repo;
	@RequestMapping( value="/" , method=RequestMethod.GET)
    public Collection<Paiement> index(Model model) {
		Collection<Paiement> etudiants =repo.findAll();
		/*for (Etudiant etudiant : etudiants) {
			System.out.println("==>");
		}*/
        return etudiants;
    }
	@RequestMapping( value="/a" , method=RequestMethod.GET)
    public Paiement get(Model model) {
		/*User user = new User("aaaaa@aaaa.com", "zakaria");
	    service.create(user);
		Collection<User> users = service.findAll();
		model.addAttribute("user", user);
		for (User us : users) {
			System.out.println("=====>"+us.getId()+"......."+ us.getEmail());
		}*/
		Paiement paiement = (Paiement)repo.findOne(1L);
        return paiement;
    }
}
