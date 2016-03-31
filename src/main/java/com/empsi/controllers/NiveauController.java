package com.empsi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public Niveau addNiveau(@RequestBody Niveau n)
	{
		if(n!= null){
		niveauMetierImpl.save(n);
		return n; 
		}else 
			return null;
		
		}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value ="/getOneNiveau/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Niveau getNiveau(@PathVariable("id") Long id)
	{
		if(niveauMetierImpl.get(id)!= null)
		return niveauMetierImpl.get(id);
		else return null;
		}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/niveaux",method = RequestMethod.GET)
	public List<Niveau> getAllNiveau()
	{
		
		return niveauMetierImpl.getAll();
		}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/deleteNiveau/{id}",method = RequestMethod.DELETE)
	public boolean deleteNiveau(@PathVariable("id") Long id)
	{ 
	     niveauMetierImpl.delete(id);
	     return true;
	}

	@RequestMapping(value="/updateNiveau/{id}" ,method = RequestMethod.PUT)
	public Niveau updateNiveaut(@PathVariable("id") Long id,@RequestBody Niveau n)
	{
		niveauMetierImpl.update(n);
		return n;
		}
	@RequestMapping(value="/addFormationToNiveau" ,method = RequestMethod.POST)
	public boolean addFormationToNiveau(@RequestParam(value="idN") Long idN,@RequestParam(value="idF") Long idF)
	{
		return niveauMetierImpl.addFormationToNiveau(idF, idN);
		
	}
}
