package com.empsi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.empsi.entities.users.Enseignant;

@Entity
public class Matiere implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idMatiere")
	private Long idMatiere;
	private String nomMatiere;
	private String description;
	
	
	
	@ManyToOne
	@JoinColumn(name="idEnseignant")
	private Enseignant enseignant;
	public Long getIdMatiere() {
		return idMatiere;
	}
	public void setIdMatiere(Long idMatiere) {
		this.idMatiere = idMatiere;
	}
	public String getNomMatiere() {
		return nomMatiere;
	}
	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public Matiere(String nomMatiere, String description) {
		super();
		this.nomMatiere = nomMatiere;
		this.description = description;
	}
	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
