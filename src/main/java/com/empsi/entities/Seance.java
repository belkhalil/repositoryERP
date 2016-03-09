package com.empsi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Seance implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSeance;
	private String Sommaire;
	private String Objet;
	private String descSeance;
	private Boolean presenceEns;
	
	@ManyToOne
	@JoinColumn(name="idSalle")
	private Salle salle;

	public Seance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seance(String sommaire, String objet, String descSeance, Boolean presenceEns) {
		super();
		Sommaire = sommaire;
		Objet = objet;
		this.descSeance = descSeance;
		this.presenceEns = presenceEns;
	}

	public Long getIdSeance() {
		return idSeance;
	}

	public void setIdSeance(Long idSeance) {
		this.idSeance = idSeance;
	}

	public String getSommaire() {
		return Sommaire;
	}

	public void setSommaire(String sommaire) {
		Sommaire = sommaire;
	}

	public String getObjet() {
		return Objet;
	}

	public void setObjet(String objet) {
		Objet = objet;
	}

	public String getDescSeance() {
		return descSeance;
	}

	public void setDescSeance(String descSeance) {
		this.descSeance = descSeance;
	}

	public Boolean getPresenceEns() {
		return presenceEns;
	}

	public void setPresenceEns(Boolean presenceEns) {
		this.presenceEns = presenceEns;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	
	
}
