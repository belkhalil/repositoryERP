package com.empsi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Materiel implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMateriel;
	private String nomMateriel;
	private String matricule;
	private Date description;
	private boolean etat;
	public Long getIdMateriel() {
		return idMateriel;
	}
	public void setIdMateriel(Long idMateriel) {
		this.idMateriel = idMateriel;
	}
	public String getNomMateriel() {
		return nomMateriel;
	}
	public void setNomMateriel(String nomMateriel) {
		this.nomMateriel = nomMateriel;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public Date getDescription() {
		return description;
	}
	public void setDescription(Date description) {
		this.description = description;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Materiel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Materiel(String nomMateriel, String matricule, Date description, boolean etat) {
		super();
		this.nomMateriel = nomMateriel;
		this.matricule = matricule;
		this.description = description;
		this.etat = etat;
	}
		
}
