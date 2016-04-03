package com.empsi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.empsi.entities.TypeFormaton;
import com.empsi.metier.TypeFormationMetierImpl;

@RestController
public class TypeFormationController {

	@Autowired
	TypeFormationMetierImpl typeFormationMetierImpl;
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	@RequestMapping(value="/savetypeFormation", method = RequestMethod.POST)
	public TypeFormaton addtypeformation(@RequestBody TypeFormaton t)
	{
		if(t!= null){
		typeFormationMetierImpl.save(t);
		return t; 
		}else 
			return null;
		
		}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value ="/getOneTypeFormation/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public TypeFormaton getTypeformation(@PathVariable("id") Long id)
	{
		if(typeFormationMetierImpl.get(id)!= null)
		return typeFormationMetierImpl.get(id);
		else return null;
		}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/typeFormations",method = RequestMethod.GET)
	public List<TypeFormaton> getAlltypesF()
	{		
		return typeFormationMetierImpl.getAll();
		}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/deleteTypeFormation/{id}",method = RequestMethod.DELETE)
	public boolean deletetypeF(@PathVariable("id") Long id)
	{ 
	     typeFormationMetierImpl.delete(id);
	     return true;
	}
/**
 * 
 * @param id
 * @param n
 * @return
 */
	@RequestMapping(value="/updateTypeFormation/{id}" ,method = RequestMethod.PUT)
	public TypeFormaton updatetypeFormation(@PathVariable("id") Long id,@RequestBody TypeFormaton t)
	{
		typeFormationMetierImpl.update(t);
		return t;
		}
}
