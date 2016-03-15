package com.empsi.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.empsi.entities.Etudiant;

import com.empsi.metier.EtudiantMetierImpl;



@Controller
public class studentController {
	
	
	@Autowired
	
	 
	 private EtudiantMetierImpl etudiantMetierImpl;

	    @Autowired
	    public void setetudiantMetierImpl(EtudiantMetierImpl etudiantMetierImpl) {
	        this.etudiantMetierImpl = etudiantMetierImpl;
	    }

	    @RequestMapping(value = "/students", method = RequestMethod.GET)
	    public String list(Model model){
	        model.addAttribute("students", etudiantMetierImpl.getAll());
	        return "students";
	    }

	    @RequestMapping("student/{id}")
	    public String showstudent(@PathVariable Long id, Model model){
	        model.addAttribute("student", etudiantMetierImpl.get(id));
	        return "studentshow";
	    }

	    @RequestMapping("student/edit/{id}")
	    public String edit(@PathVariable Long id, Model model){
	    	Etudiant etudient=etudiantMetierImpl.get(id);
	        model.addAttribute("student", etudiantMetierImpl.Update(etudient));
	        return "inscriptionform";
	    }

	    @RequestMapping("student/new")
	    public String newstudent(Model model){
	        model.addAttribute("student", new Etudiant());
	        return "inscriptionform";
	    }

	    @RequestMapping(value = "student", method = RequestMethod.POST)
	    public String saveStudent(Etudiant student){
	    	etudiantMetierImpl.save(student);
	        return "redirect:/student/" + student.getIdUtilisateur();
	    }

	    @RequestMapping("student/delete/{id}")
	    public String delete(@PathVariable Long id){
	    	
	    	boolean res= etudiantMetierImpl.delete(id);
	    	if(res==true){
	        return "redirect:/students";
	    	}
	    	else
	    		return null;
	    }

	}
