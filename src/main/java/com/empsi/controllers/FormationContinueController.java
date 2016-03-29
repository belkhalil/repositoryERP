package com.empsi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.FormationContinu;
import com.empsi.metier.FormationContinueMetierImpl;


@RestController
public class FormationContinueController {

	@Autowired
	private FormationContinueMetierImpl formationContinueMetierImpl;

	@RequestMapping(value = "/saveformation", method = RequestMethod.POST)
	public FormationContinu addformation(@RequestBody FormationContinu e) {
		formationContinueMetierImpl.save(e);
		return e;

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getOneFormation/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public FormationContinu getFormation(@PathVariable("id") Long id) {
		if (formationContinueMetierImpl.get(id) != null)
			return formationContinueMetierImpl.get(id);
		else
			return null;
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/formations", method = RequestMethod.GET)
	public List<FormationContinu> getAllformations() {

		return formationContinueMetierImpl.getAll();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteformation/{id}", method = RequestMethod.DELETE)
	public boolean deleteFormation(@PathVariable("id") Long id) {
		formationContinueMetierImpl.delete(id);
		return true;
	}

	/**
	 * 
	 * @param id
	 * @param e
	 * @return
	 */
	@RequestMapping(value = "/updateFormation/{id}", method = RequestMethod.PUT)
	public FormationContinu updateFormation(@PathVariable("id") Long id, @RequestBody FormationContinu e) {
		formationContinueMetierImpl.update(e);
		return e;
	}

}
