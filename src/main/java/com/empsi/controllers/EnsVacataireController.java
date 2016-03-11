package com.empsi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.empsi.entities.EnsVacataire;
import com.empsi.metier.EnsVacataireMetierImpl;

@Controller
public class EnsVacataireController {
	
@Autowired
  private EnsVacataireMetierImpl ensVacataireMetierImpl;

	@RequestMapping(value = "/ensVacataires", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("ensVacataires", ensVacataireMetierImpl.getAll());
		return "ensVacataires";
	}

	@RequestMapping("ensVacataire/{id}")
	public String showstudent(@PathVariable Long id, Model model) {
		model.addAttribute("ensVacataire", ensVacataireMetierImpl.get(id));
		return "ensVacataireshow";
	}

	@RequestMapping("ensVacataire/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		EnsVacataire ensv = ensVacataireMetierImpl.get(id);
		model.addAttribute("ensVacataire", ensVacataireMetierImpl.update(ensv));
		return "EnsvInscriptionform";
	}

	@RequestMapping("ensVacataire/new")
	public String newstudent(Model model) {
		model.addAttribute("ensVacataire", new EnsVacataire());
		return "EnsvInscriptionform";
	}

	@RequestMapping(value = "ensVacataire", method = RequestMethod.POST)
	public String saveStudent(EnsVacataire Ensv) {
		ensVacataireMetierImpl.save(Ensv);
		return "redirect:/ensVacataire/" + Ensv.getIdUtilisateur();
	}

	@RequestMapping("ensVacataire/delete/{id}")
	public String delete(@PathVariable Long id) {

		boolean res = ensVacataireMetierImpl.delete(id);
		if (res == true) {
			return "redirect:/ensVacataires";
		} else
			return null;
	}
}
