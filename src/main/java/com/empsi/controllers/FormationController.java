package com.empsi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.empsi.entities.Formation;
import com.empsi.metier.FormationMetierImpl;
@Controller
public class FormationController {
	
	@Autowired
	 private FormationMetierImpl formationMetierImpl;
	

	@RequestMapping(value = "/formations", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("formations", formationMetierImpl.getAll());
		return "formations";
	}

	@RequestMapping("/formation/{id}")
	public String showformation(@PathVariable Long id, Model model) {
		model.addAttribute("formation", formationMetierImpl.get(id));
		return "formationShow";
	}

	@RequestMapping("formation/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Formation formation = formationMetierImpl.get(id);
		model.addAttribute("formation", formationMetierImpl.update(formation));
		return "formationform";
	}

	@RequestMapping("/formation/new")
	public String newformation(Model model) {
		model.addAttribute("formation",new Formation());
		return "formationform";
	}

	@RequestMapping(value ="/formation", method = RequestMethod.POST)
	public String saveFormation(@Valid Formation forma , BindingResult bindingResult){
		formationMetierImpl.save(forma);
		return "redirect:/formations";
		
	}

	@RequestMapping("/formation/delete/{id}")
	public String deleteFormation(@PathVariable Long id) {

		boolean res = formationMetierImpl.delete(id);
		if (res == true) {
			return "redirect:/formations";
		} else
			return null;
	}

}
