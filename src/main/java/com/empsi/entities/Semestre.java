package com.empsi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Semestre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSemestre;
    
	private String nomSemestre;
	
	
	public Long getIdSemestre() {
		return idSemestre;
	}


	public void setIdSemestre(Long idSemestre) {
		this.idSemestre = idSemestre;
	}


	public String getNomSemestre() {
		return nomSemestre;
	}


	public void setNomSemestre(String nomSemestre) {
		this.nomSemestre = nomSemestre;
	}


	@ManyToOne
	@JoinColumn(name="idNiveau")
	private Niveau niveau;
} 
