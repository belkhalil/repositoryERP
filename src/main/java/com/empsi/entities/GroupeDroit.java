package com.empsi.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class GroupeDroit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idGroupe;
	private String nomGroupe;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "droitsUser", joinColumns = { 
			@JoinColumn(name = "idGroupe", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "idUtilisateur", 
					nullable = false, updatable = false) })
	private List<Utilisateur> users;
	
	public List<Utilisateur> getUsers() {
		return users;
	}
	public void setUsers(List<Utilisateur> users) {
		this.users = users;
	}
	public Long getIdGroupe() {
		return idGroupe;
	}
	public void setIdGroupe(Long idGroupe) {
		this.idGroupe = idGroupe;
	}
	public String getNomGroupe() {
		return nomGroupe;
	}
	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}
	public GroupeDroit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GroupeDroit(String nomGroupe) {
		super();
		this.nomGroupe = nomGroupe;
	}
	
	
	

}
