package com.empsi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexEtudiantController {

	
	    @RequestMapping("/stud")
	    String index(){
	        return "indexEtudiant";
	    }
}

