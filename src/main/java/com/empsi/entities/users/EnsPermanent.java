package com.empsi.entities.users;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class EnsPermanent extends Enseignant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double salaireMensuel;
	public EnsPermanent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EnsPermanent(String nomUtilisateur, String prenomUtilisateur, String cinUtilisateur, String emailUtilisateur,
			Date dateNaissance, String villeNaissance, String paysNaissance, String adresseUtilisateur,
			String telUtilisateur, String telFixUtilisateur, String professionUtilisateur, int nbrHeureSemaine,
			double salaireMensuel) {
		super(nomUtilisateur, prenomUtilisateur, cinUtilisateur, emailUtilisateur, dateNaissance, villeNaissance,
				paysNaissance, adresseUtilisateur, telUtilisateur, telFixUtilisateur, professionUtilisateur,
				nbrHeureSemaine);
		this.salaireMensuel = salaireMensuel;
	}
	public double getSalaireMensuel() {
		return salaireMensuel;
	}
	public void setSalaireMensuel(double salaireMensuel) {
		this.salaireMensuel = salaireMensuel;
	}
	
	
}
