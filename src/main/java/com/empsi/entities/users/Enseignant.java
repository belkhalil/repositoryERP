package com.empsi.entities.users;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.empsi.entities.Matiere;

@Entity
public abstract class Enseignant extends Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nbrHeureSemaine;
	
	@OneToMany(mappedBy = "enseignant")
    private List<Matiere> matieres;

	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enseignant(String nomUtilisateur, String prenomUtilisateur, String cinUtilisateur, String emailUtilisateur,
			Date dateNaissance, String villeNaissance, String paysNaissance, String adresseUtilisateur,
			String telUtilisateur, String telFixUtilisateur, String professionUtilisateur, int nbrHeureSemaine) {
		super(nomUtilisateur, prenomUtilisateur, cinUtilisateur, emailUtilisateur, dateNaissance, villeNaissance,
				paysNaissance, adresseUtilisateur, telUtilisateur, telFixUtilisateur, professionUtilisateur);
		this.nbrHeureSemaine = nbrHeureSemaine;
	}

	public int getNbrHeureSemaine() {
		return nbrHeureSemaine;
	}

	public void setNbrHeureSemaine(int nbrHeureSemaine) {
		this.nbrHeureSemaine = nbrHeureSemaine;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}
}
