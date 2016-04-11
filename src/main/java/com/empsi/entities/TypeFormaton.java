package com.empsi.entities;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TypeFormaton implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTypeFormation;
	
	private String LabelTypeFormation;
	
    @JsonIgnore
	@ManyToOne
    @JoinColumn(name = "idFormation")
    private Formation formation;
	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}


	public TypeFormaton() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeFormaton(Long idTypeFormation, String labelTypeFormation) {
		super();
		this.idTypeFormation = idTypeFormation;
		LabelTypeFormation = labelTypeFormation;
	}

	
	public Long getIdTypeFormation() {
		return idTypeFormation;
	}

	public void setIdTypeFormation(Long idTypeFormation) {
		this.idTypeFormation = idTypeFormation;
	}

	public String getLabelTypeFormation() {
		return LabelTypeFormation;
	}

	public void setLabelTypeFormation(String labelTypeFormation) {
		LabelTypeFormation = labelTypeFormation;
	}
	
	
	
	
}
