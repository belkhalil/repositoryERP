package com.empsi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.empsi.entities.users.EnsPermanent;
import com.empsi.metier.EnsPermanentMetierImpl;

@Controller
public class EnsPermanentController {

	@Autowired
	private EnsPermanentMetierImpl ensPermanentMetierImpl;

	

	@RequestMapping(value = "/ensPermanents", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("ensPermanents", ensPermanentMetierImpl.getAll());
		return "ensPermanents";
	}

	@RequestMapping("ensPermanent/{id}")
	public String showstudent(@PathVariable Long id, Model model) {
		model.addAttribute("ensPermanent", ensPermanentMetierImpl.get(id));
		return "ensPermanentshow";
	}

	@RequestMapping("ensPermanent/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		EnsPermanent ensp = ensPermanentMetierImpl.get(id);
		model.addAttribute("ensPermanent", ensPermanentMetierImpl.update(ensp));
		return "EnspInscriptionform";
	}

	@RequestMapping("ensPermanent/new")
	public String newstudent(Model model) {
		model.addAttribute("ensPermanent", new EnsPermanent());
		return "EnspInscriptionform";
	}

	@RequestMapping(value = "ensPermanent", method = RequestMethod.POST)
	public String saveStudent(EnsPermanent Ensp) {
		ensPermanentMetierImpl.save(Ensp);
		return "redirect:/ensPermanent/" + Ensp.getIdUtilisateur();
	}

	@RequestMapping("ensPermanent/delete/{id}")
	public String delete(@PathVariable Long id) {

		boolean res = ensPermanentMetierImpl.delete(id);
		if (res == true) {
			return "redirect:/ensPermanents";
		} else
			return null;
	}

}
