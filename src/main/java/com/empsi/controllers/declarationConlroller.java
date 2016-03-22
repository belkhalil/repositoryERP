package com.empsi.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.loader.custom.Return;
import org.springframework.asm.commons.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.empsi.entities.Declaration;
import com.empsi.entities.users.Etudiant;
import com.empsi.metier.DeclarationMetierImpl;
import com.empsi.metier.EtudiantMetierImpl;





@Controller
public class declarationConlroller {

	@Autowired
	private DeclarationMetierImpl declarationMetierImpl;
	@Autowired
	private  EtudiantMetierImpl etudiantMetierImpl;
	
	

	
	/**
	 * get declatation by id 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/declaration/{id}" ,method=RequestMethod.GET)
	public String getDeclarationById(@PathVariable Long id , Model model)
	{
	model.addAttribute("declaration",declarationMetierImpl.get(id));
	return "Declarationshow";
	}
	
	/**
	 * tout les declaration
	 * @return
	 */
	@RequestMapping(value="/declarations" ,method=RequestMethod.GET)
	public String list(Model model)
	{
	 model.addAttribute("declarations", declarationMetierImpl.getAll());
	 return "declarations";
	}
	 /**
	  * edit declaration
	  * @param id
	  * @param model
	  * @return
	  */
	@RequestMapping("declaration/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("product", declarationMetierImpl.get(id));
        return "declarationForm";
    }
	/**
	 * new declaration
	 * @param model
	 * @return
	 */
	@RequestMapping("declaration/new/{idUser}")
    public String newDeclarationEtudiant(@PathVariable Long idUser,Model model){
		Declaration declaration=new Declaration();
		Etudiant e=etudiantMetierImpl.get(idUser);
		declaration.setUtilisateur(e);
        model.addAttribute(declaration);
        return "declarationForm";
    }
	
	/**
	 * 
	 * @param declaration
	 * @return
	 */
	 @RequestMapping(value = "declaration", method = RequestMethod.POST)
	    public String saveDeclaration(Declaration declaration){
	        declarationMetierImpl.save(declaration);
	        return "redirect:/declaration/" + declaration.getIdDeclaration();
	    }
    /**
     * 
     * @param id
     * @return
     */
	    @RequestMapping("declaration/delete/{id}")
	    public String delete(@PathVariable Long id){
	        declarationMetierImpl.delete(id);
	        return "redirect:/declarations";
	    }		
}

