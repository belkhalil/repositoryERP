package com.empsi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class EnsVacataire extends Enseignant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double salaireHeure;
	public EnsVacataire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EnsVacataire(String nomUtilisateur, String prenomUtilisateur, String cinUtilisateur, String emailUtilisateur,
			Date dateNaissance, String villeNaissance, String paysNaissance, String adresseUtilisateur,
			String telUtilisateur, String telFixUtilisateur, String professionUtilisateur, int nbrHeureSemaine,
			double salaireHeure) {
		super(nomUtilisateur, prenomUtilisateur, cinUtilisateur, emailUtilisateur, dateNaissance, villeNaissance,
				paysNaissance, adresseUtilisateur, telUtilisateur, telFixUtilisateur, professionUtilisateur,
				nbrHeureSemaine);
		this.salaireHeure = salaireHeure;
	}
	public double getSalaireHeure() {
		return salaireHeure;
	}
	public void setSalaireHeure(double salaireHeure) {
		this.salaireHeure = salaireHeure;
	}
	
	
	
}
