package com.empsi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Classe implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idClasse")
	private Long idClasse;
	private String nomClasse;
	private int nbrEtudiant;
	
	@ManyToOne
    @JoinColumn(name = "idAnnee")
	private AnneeScolaire anneScolaire;

	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Classe(String nomClasse, int nbrEtudiant) {
		super();
		this.nomClasse = nomClasse;
		this.nbrEtudiant = nbrEtudiant;
	}

	public Long getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(Long idClasse) {
		this.idClasse = idClasse;
	}

	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}

	public int getNbrEtudiant() {
		return nbrEtudiant;
	}

	public void setNbrEtudiant(int nbrEtudiant) {
		this.nbrEtudiant = nbrEtudiant;
	}

	public AnneeScolaire getAnneScolaire() {
		return anneScolaire;
	}

	public void setAnneScolaire(AnneeScolaire anneScolaire) {
		this.anneScolaire = anneScolaire;
	}
	
	
	
}
