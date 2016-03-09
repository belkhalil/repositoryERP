package com.empsi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Compte implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCompte")
	private Long idCompte;
	private String Login;
	private String password;
	private Boolean etatCompte;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "compte")
	@JoinColumn(name = "idUtilisateur", referencedColumnName= "idUtilisateur")
	private Utilisateur utilisateur;

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte(String login, String password, Boolean etatCompte) {
		super();
		Login = login;
		this.password = password;
		this.etatCompte = etatCompte;
	}

	public Long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEtatCompte() {
		return etatCompte;
	}

	public void setEtatCompte(Boolean etatCompte) {
		this.etatCompte = etatCompte;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	
	
}
