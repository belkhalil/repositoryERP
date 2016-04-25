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

import com.empsi.entities.Module;
import com.empsi.metier.ModuleMetierImpl;

@RestController
public class ModuleController {
	
	
	@Autowired
	ModuleMetierImpl moduleMetierImpl;
	
	
	@RequestMapping(value="/saveModule", method = RequestMethod.POST)
	public ResponseEntity<Module> addModule(@RequestBody Module m)
	{
		moduleMetierImpl.save(m);
		return new ResponseEntity<Module>(m,HttpStatus.CREATED);
		
		}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value ="/getOneModule/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Module> getModule(@PathVariable("id") Long id)
	{ 
		Module module = moduleMetierImpl.get(id);
		if(module == null)
		{
			return new ResponseEntity<Module>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Module>(module, HttpStatus.OK);
		}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/modules",method = RequestMethod.GET)
	public ResponseEntity<List<Module>>  getAllModule()
	{
		List<Module> modules= moduleMetierImpl.getAll();
		if(modules.isEmpty())
		{
			return new ResponseEntity<List<Module>>(HttpStatus.NO_CONTENT);	
		}
		return new ResponseEntity<List<Module>>(modules, HttpStatus.OK);		}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/deleteModule/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Module> deleteModule(@PathVariable("id") Long id)
	{ 
		Module module =moduleMetierImpl.get(id);
		if(module==null)
		{
			return new ResponseEntity<Module>(HttpStatus.NOT_FOUND);	
		}
	     moduleMetierImpl.delete(id);
	     return new ResponseEntity<Module>(HttpStatus.OK);
	}
/**
 * 
 * @param id
 * @param n
 * @return
 */
	@RequestMapping(value="/updateModule/{id}" ,method = RequestMethod.PUT)
	public ResponseEntity<Module> updateModule(@PathVariable("id") Long id,@RequestBody Module m)
	{
		moduleMetierImpl.Update(m);
		return new ResponseEntity<Module>(HttpStatus.OK);
		}
		/**
		 * 
		 * @param idN
		 * @param idF
		 * @return
		 */
	@RequestMapping(value="/addModuleToSemestre" ,method = RequestMethod.POST)
	public ResponseEntity<Module> addModuleToSemestre(@RequestParam(value="idm") Long idM ,@RequestParam(value="ids") Long idS)
	{
		moduleMetierImpl.addModuleToSemestre(idM, idS);
		return new ResponseEntity<Module>(HttpStatus.OK);
		
	}
	
	/**
	 * 
	 * @param idN
	 * @param idS
	 * @return
	 */
	@RequestMapping(value="/removeModuleFromSemestre" ,method = RequestMethod.DELETE)
	public ResponseEntity<Module> removeModuleFromSemestre(@RequestParam(value="idm") Long idM ,@RequestParam(value="ids") Long idS)
	{
		moduleMetierImpl.removeModuleFromSemestre(idM, idS);
		return new ResponseEntity<Module>(HttpStatus.OK);
	}
	/**
	 * 
	 * @param idMa
	 * @param idMo
	 * @return
	 */
	@RequestMapping(value="/addMatiereToModule" ,method = RequestMethod.POST)
	public ResponseEntity<Module> addMatiereToModule(@RequestParam(value="idma") Long idMa ,@RequestParam(value="idmo") Long idMo)
	{
		moduleMetierImpl.addMatierToModule(idMa, idMo);
		
		return new ResponseEntity<Module>(HttpStatus.OK);
		
	}
	
	/**
	 * 
	 * @param idMa
	 * @param idMo
	 * @return
	 */
	@RequestMapping(value="/removeMatiereFromModule" ,method = RequestMethod.POST)
	public ResponseEntity<Module> removeMatiereFromModule(@RequestParam(value="idma") Long idMa ,@RequestParam(value="idmo") Long idMo)
	{
		moduleMetierImpl.removeMatierFromModule(idMa, idMo);
		
		return new ResponseEntity<Module>(HttpStatus.OK);
		
	}

}
