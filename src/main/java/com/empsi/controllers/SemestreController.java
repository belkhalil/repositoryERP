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

import com.empsi.entities.Niveau;
import com.empsi.entities.Semestre;
import com.empsi.metier.SemestreMetierImpl;

@RestController
public class SemestreController {

	@Autowired
	SemestreMetierImpl semestreMetierImpl;

	@RequestMapping(value = "/saveSemestre", method = RequestMethod.POST)
	public ResponseEntity<Semestre> addSemestre(@RequestBody Semestre s) {

		semestreMetierImpl.saveSemestre(s);
		return new ResponseEntity<Semestre>(s, HttpStatus.CREATED);

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getOneSemestre/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Semestre> getSemestre(@PathVariable("id") Long id) {
		Semestre semestre = semestreMetierImpl.getSemestre(id);
		if (semestre == null) {
			return new ResponseEntity<Semestre>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Semestre>(semestre, HttpStatus.OK);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/Semestres", method = RequestMethod.GET)
	public ResponseEntity<List<Semestre>> getAllSemestres() {
		List<Semestre> semestres = semestreMetierImpl.getAll();
		if (semestres.isEmpty()) {
			return new ResponseEntity<List<Semestre>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Semestre>>(semestres, HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteSemestre/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Semestre> deleteSemestre(@PathVariable("id") Long id) {
		Semestre semestre = semestreMetierImpl.getSemestre(id);
		if (semestre == null) {
			return new ResponseEntity<Semestre>(HttpStatus.NOT_FOUND);
		}
		semestreMetierImpl.deleteSemestre(id);
		return new ResponseEntity<Semestre>(HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @param n
	 * @return
	 */
	@RequestMapping(value = "/updateSemestre/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Semestre> updateSemestre(@PathVariable("id") Long id, @RequestBody Semestre s) {
		semestreMetierImpl.updateSemestre(s);
		return new ResponseEntity<Semestre>(HttpStatus.OK);
	}

}
