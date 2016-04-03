package com.empsi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.FormationDiplomante;
import com.empsi.entities.TypeFormaton;
import com.empsi.metier.FormationDiplomanteImpl;

@RestController
public class FormationDiplomanteController  {
   @Autowired
	FormationDiplomanteImpl formationDiplomanteImpl;
   
   @RequestMapping(value = "/saveformationD", method = RequestMethod.POST)
	public FormationDiplomante addformation(@RequestBody FormationDiplomante e) {
		formationDiplomanteImpl.save(e);
		
		return e;

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getOneFormationD/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public FormationDiplomante getFormation(@PathVariable("id") Long id) {
		if (formationDiplomanteImpl.get(id) != null)
			return formationDiplomanteImpl.get(id);
		else
			return null;
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/formationsD", method = RequestMethod.GET)
	public List<FormationDiplomante> getAllformations() {

		return formationDiplomanteImpl.getAll();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteformationD/{id}", method = RequestMethod.DELETE)
	public boolean deleteFormation(@PathVariable("id") Long id) {
		formationDiplomanteImpl.delete(id);
		return true;
	}

	/**
	 * 
	 * @param id
	 * @param e
	 * @return
	 */
	@RequestMapping(value = "/updateFormationD/{id}", method = RequestMethod.PUT)
	public FormationDiplomante updateFormation(@PathVariable("id") Long id, @RequestBody FormationDiplomante e) {
		formationDiplomanteImpl.update(e);
		return e;
	}
}
