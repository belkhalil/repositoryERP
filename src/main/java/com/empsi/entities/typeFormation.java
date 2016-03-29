package com.empsi.entities;

public enum typeFormation {
	Cours_du_soir("Cours du soire"),
	Cours_du_week_end("Cours week end"),
	Cours_du_jour("Cours du jour");
	
	
	  private String name = "";
	 
	  //Constructeur
	  typeFormation(String name){
	    this.name = name;
	  }
	  
	  public String toString(){
	    return name;
	  }
	}

