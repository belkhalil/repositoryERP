package com.empsi.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.users.EnsPermanent;
import com.empsi.metier.EnsPermanentMetierImpl;

@RestController
public class EnsPermanentController {

	@Autowired
	private EnsPermanentMetierImpl ensPermanentMetierImpl;

	
   /**
    * 
    * @return
    */
	@RequestMapping(value = "/ensPermanents", method = RequestMethod.GET)
	public List<EnsPermanent> list() {
		return ensPermanentMetierImpl.getAll();
		}
	
		
   /**
    * 
    * @param e
    * @return
    */
	@RequestMapping(value="/saveEnsp", method = RequestMethod.POST)
	public EnsPermanent addensP(@RequestBody EnsPermanent e)
	{
		ensPermanentMetierImpl.save(e);
		return e; 
		
		}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value ="/getOneEnsp/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public EnsPermanent getEnsP(@PathVariable("id") Long id)
	{
		if(ensPermanentMetierImpl.get(id)!= null)
		return ensPermanentMetierImpl.get(id);
		else 
			return null;
		}

	
	/**
	 * 
	 * @param id
	 * @return
	 */
	
	@RequestMapping(value="/deleteEnsP/{id}",method = RequestMethod.DELETE)
	public boolean deleteEnsP(@PathVariable("id") Long id)
	{ 
	     ensPermanentMetierImpl.delete(id);
	     return true;
	}
    /**
     * 
     * @param id
     * @param ens
     * @return
     */
	@RequestMapping(value="/updateEnsP/{id}" ,method = RequestMethod.PUT)
	public EnsPermanent updateEnsP(@PathVariable("id") Long id,@RequestBody EnsPermanent ens)
	{
		ensPermanentMetierImpl.update(ens);
		return ens;
		}
	 

}
