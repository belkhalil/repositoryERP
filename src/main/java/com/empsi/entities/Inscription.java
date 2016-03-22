package com.empsi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.empsi.entities.users.Etudiant;

@Entity
public class Inscription implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idInscription")
	private Long idInsc;
	private String numeroInsc;
	private Date dateInsc;
	
	private String diponibilitè;  //jour ou soir ou le weekend
	@ManyToOne
    @JoinColumn(name = "idUtilisateur")
	private Etudiant etudiant;
	@ManyToOne
    @JoinColumn(name = "idFormation")
	private Formation formation;
	public Long getIdInsc() {
		return idInsc;
	}
	public void setIdInsc(Long idInsc) {
		this.idInsc = idInsc;
	}
	public String getNumeroInsc() {
		return numeroInsc;
	}
	public void setNumeroInsc(String numeroInsc) {
		this.numeroInsc = numeroInsc;
	}
	public Date getDateInsc() {
		return dateInsc;
	}
	public void setDateInsc(Date dateInsc) {
		this.dateInsc = dateInsc;
	}
	public String getDiponibilitè() {
		return diponibilitè;
	}
	public void setDiponibilitè(String diponibilitè) {
		this.diponibilitè = diponibilitè;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inscription(String numeroInsc, Date dateInsc, String diponibilitè) {
		super();
		this.numeroInsc = numeroInsc;
		this.dateInsc = dateInsc;
		this.diponibilitè = diponibilitè;
	}
	
	
}
