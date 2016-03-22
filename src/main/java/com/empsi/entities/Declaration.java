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

import com.empsi.entities.users.Utilisateur;
@Entity
public class Declaration implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idDeclaration")
	private Long idDeclaration;
	private String objet;
	private String contenu;
	private String typeDeclaration;
	private Date datedeclaration;
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	private Utilisateur utilisateur;
	public Long getIdDeclaration() {
		return idDeclaration;
	}
	public void setIdDeclaration(Long idDeclaration) {
		this.idDeclaration = idDeclaration;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public String getTypeDeclaration() {
		return typeDeclaration;
	}
	public void setTypeDeclaration(String typeDeclaration) {
		this.typeDeclaration = typeDeclaration;
	}
	public Date getDatedeclaration() {
		return datedeclaration;
	}
	public void setDatedeclaration(Date datedeclaration) {
		this.datedeclaration = datedeclaration;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Declaration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Declaration(String objet, String contenu, String typeDeclaration, Date datedeclaration) {
		super();
		this.objet = objet;
		this.contenu = contenu;
		this.typeDeclaration = typeDeclaration;
		this.datedeclaration = datedeclaration;
	}
	
}
