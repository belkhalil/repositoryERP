package com.empsi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class indexEnsVacataireController {
	
	@RequestMapping("/ensv")
    String index(){
        return "indexEnsVacataire";
    }

}
