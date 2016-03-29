package com.empsi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.users.EnsVacataire;
import com.empsi.metier.EnsVacataireMetierImpl;

@RestController
public class EnsVacataireController {
	
@Autowired
  private EnsVacataireMetierImpl ensVacataireMetierImpl;


/**
 * 
 * @return
 */
	@RequestMapping(value = "/ensVacatires", method = RequestMethod.GET)
	public List<EnsVacataire> list() {
		List<EnsVacataire> ensVacataires = ensVacataireMetierImpl.getAll();
		return ensVacataires;
	}
/**
 * 
 * @param e
 * @return
 */
	@RequestMapping(value="/saveEnsv", method = RequestMethod.POST)
	public EnsVacataire addensV(@RequestBody EnsVacataire e)
	{
		ensVacataireMetierImpl.save(e);
		return e; 
		
		}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value ="/getOneEnsV/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public EnsVacataire getEnsV(@PathVariable("id") Long id)
	{
		if(ensVacataireMetierImpl.get(id)!= null)
		return ensVacataireMetierImpl.get(id);
		else 
			return null;
		}

	
	/**
	 * 
	 * @param id
	 * @return
	 */
	
	@RequestMapping(value="/deleteEnsV/{id}",method = RequestMethod.DELETE)
	public boolean deleteEnsV(@PathVariable("id") Long id)
	{ 
	     ensVacataireMetierImpl.delete(id);
	     return true;
	}
 /**
  * 
  * @param id
  * @param ens
  * @return
  */
	@RequestMapping(value="/updateEnsV/{id}" ,method = RequestMethod.PUT)
	public EnsVacataire updateEnsV(@PathVariable("id") Long id,@RequestBody EnsVacataire ens)
	{
		ensVacataireMetierImpl.update(ens);
		return ens;
		}
	 
}
