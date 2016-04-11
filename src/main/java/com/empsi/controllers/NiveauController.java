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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.FormationDiplomante;
import com.empsi.entities.Niveau;
import com.empsi.metier.FormationDiplomanteImpl;
import com.empsi.metier.NiveauMetierImpl;

@RestController
public class NiveauController {
   
	@Autowired
	NiveauMetierImpl niveauMetierImpl;
	
	@Autowired
	FormationDiplomanteImpl formationDiplomanteImpl;
	
	@RequestMapping(value="/saveNiveau", method = RequestMethod.POST)
	public ResponseEntity<Niveau> addNiveau(@RequestBody Niveau n)
	{
		niveauMetierImpl.save(n);
		return new ResponseEntity<Niveau>(n,HttpStatus.CREATED);
		
		}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value ="/getOneNiveau/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Niveau> getNiveau(@PathVariable("id") Long id)
	{ 
		Niveau niveau = niveauMetierImpl.get(id);
		if(niveau == null)
		{
			return new ResponseEntity<Niveau>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Niveau>(niveau, HttpStatus.OK);
		}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/niveaux",method = RequestMethod.GET)
	public ResponseEntity<List<Niveau>>  getAllNiveau()
	{
		List<Niveau> niveaus= niveauMetierImpl.getAll();
		if(niveaus.isEmpty())
		{
			return new ResponseEntity<List<Niveau>>(HttpStatus.NO_CONTENT);	
		}
		return new ResponseEntity<List<Niveau>>(niveaus, HttpStatus.OK);		}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/deleteNiveau/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Niveau> deleteNiveau(@PathVariable("id") Long id)
	{ 
		Niveau niveau =niveauMetierImpl.get(id);
		if(niveau==null)
		{
			return new ResponseEntity<Niveau>(HttpStatus.NOT_FOUND);	
		}
	     niveauMetierImpl.delete(id);
	     return new ResponseEntity<Niveau>(HttpStatus.OK);
	}
/**
 * 
 * @param id
 * @param n
 * @return
 */
	@RequestMapping(value="/updateNiveau/{id}" ,method = RequestMethod.PUT)
	public ResponseEntity<Niveau> updateNiveaut(@PathVariable("id") Long id,@RequestBody Niveau n)
	{
		niveauMetierImpl.update(n);
		return new ResponseEntity<Niveau>(HttpStatus.OK);
		}
		/**
		 * 
		 * @param idN
		 * @param idF
		 * @return
		 */
	@RequestMapping(value="/addFormationToNiveau" ,method = RequestMethod.POST)
	public ResponseEntity<Niveau> addFormationToNiveau(@RequestParam(value="idn") Long idN ,@RequestParam(value="idf") Long idF)
	{
		niveauMetierImpl.addFormationToNiveau(idF, idN);
		return new ResponseEntity<Niveau>(HttpStatus.OK);
		
	}
	/**
	 * 
	 * @param idN
	 * @param idF
	 * @return
	 */
	@RequestMapping(value="/removeFormationFromNiveau" ,method = RequestMethod.DELETE)
	public ResponseEntity<Niveau> removeFormationFromNiveau(@RequestParam(value="idn") Long idN ,@RequestParam(value="idf") Long idF)
	{
		niveauMetierImpl.removeFormationFromNiveau(idF, idN);
		return new ResponseEntity<Niveau>(HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param idN
	 * @param idS
	 * @return
	 */
	@RequestMapping(value="/removeSemestreFromNiveau" ,method = RequestMethod.DELETE)
	public ResponseEntity<Niveau> removeSemestreFromNiveau(@RequestParam(value="idn") Long idN ,@RequestParam(value="ids") Long idS)
	{
		niveauMetierImpl.removeFormationFromNiveau(idS, idN);
		return new ResponseEntity<Niveau>(HttpStatus.OK);
	}
	
	 /**	  * 
	  * @param idS
	  * @param idN
	  * @return
	  */
	@RequestMapping(value="/addSemestreToNiveau" ,method = RequestMethod.POST)
	public ResponseEntity<Niveau> addSemestreToNiveau(@RequestParam(value="ids") Long idS ,@RequestParam(value="idn") Long idN)
	{
		niveauMetierImpl.addSemestreToNiveau(idS, idN);
		return new ResponseEntity<Niveau>(HttpStatus.OK);
		
	}
}
