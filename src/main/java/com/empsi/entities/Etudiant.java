package com.empsi.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Etudiant extends Utilisateur implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cne;
	private String anneeObtentionBac;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "classe_etudiant", joinColumns = { 
			@JoinColumn(name = "idEtudiant", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "idClasse", 
					nullable = false, updatable = false) })
	private List<Classe> classes;
	@ManyToOne
	@JoinColumn(name="idParent")
	private Parent parent;
	@OneToMany(mappedBy = "etudiant")
    private List<AbsenceEtudiant> absences;
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Etudiant(String nomUtilisateur, String prenomUtilisateur, String cinUtilisateur, String emailUtilisateur,
			Date dateNaissance, String villeNaissance, String paysNaissance, String adresseUtilisateur,
			String telUtilisateur, String telFixUtilisateur, String professionUtilisateur, String cNE,
			String anneeObtentionBac) {
		super(nomUtilisateur, prenomUtilisateur, cinUtilisateur, emailUtilisateur, dateNaissance, villeNaissance,
				paysNaissance, adresseUtilisateur, telUtilisateur, telFixUtilisateur, professionUtilisateur);
		this.cne = cNE;
		this.anneeObtentionBac = anneeObtentionBac;
	}
	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
	}
	public String getAnneeObtentionBac() {
		return anneeObtentionBac;
	}
	public void setAnneeObtentionBac(String anneeObtentionBac) {
		this.anneeObtentionBac = anneeObtentionBac;
	}
	public List<Classe> getClasses() {
		return classes;
	}
	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}
	public Parent getParent() {
		return parent;
	}
	public void setParent(Parent parent) {
		this.parent = parent;
	}
	public List<AbsenceEtudiant> getAbsences() {
		return absences;
	}
	public void setAbsences(List<AbsenceEtudiant> absences) {
		this.absences = absences;
	}
	
	
	
	
	

}
