package com.empsi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexEnsPermanentController {

	
	
	
	    @RequestMapping("/ensp")
	    String index(){
	        return "indexEnsPermanent";
	    }
}
