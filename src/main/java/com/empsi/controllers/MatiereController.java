package com.empsi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.Matiere;
import com.empsi.metier.MatierMetierImpl;

@RestController
public class MatiereController {

	@Autowired
	MatierMetierImpl matierMetierImpl;

	/**
	 * 
	 * @param m
	 * @return
	 */
	@RequestMapping(value = "/saveMatiere", method = RequestMethod.POST)
	public ResponseEntity<Matiere> addMatiere(@RequestBody Matiere m) {
		matierMetierImpl.save(m);
		return new ResponseEntity<Matiere>(m, HttpStatus.CREATED);

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getOneMatiere/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Matiere> getMatiere(@PathVariable("id") Long id) {
		Matiere matiere = matierMetierImpl.get(id);
		if (matiere == null) {
			return new ResponseEntity<Matiere>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Matiere>(matiere, HttpStatus.OK);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/matieres", method = RequestMethod.GET)
	public ResponseEntity<List<Matiere>> getAllMatieres() {
		List<Matiere> matieres = matierMetierImpl.getAll();
		if (matieres.isEmpty()) {
			return new ResponseEntity<List<Matiere>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Matiere>>(matieres, HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteMatiere/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Matiere> deleteMatiere(@PathVariable("id") Long id) {
		Matiere matiere = matierMetierImpl.get(id);
		if (matiere == null) {
			return new ResponseEntity<Matiere>(HttpStatus.NOT_FOUND);
		}
		matierMetierImpl.delete(id);
		return new ResponseEntity<Matiere>(HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @param n
	 * @return
	 */
	@RequestMapping(value = "/updateMatiere/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Matiere> updateMatiere(@PathVariable("id") Long id, @RequestBody Matiere m) {
		matierMetierImpl.Update(m);
		return new ResponseEntity<Matiere>(HttpStatus.OK);
	}
}
