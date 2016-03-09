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
public class Droit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDroit;
	private String nomDroit;
	private String action;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "droit_groupe", joinColumns = { 
			@JoinColumn(name = "idDroit", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "idGroupeDroit", 
					nullable = false, updatable = false) })
	private List<GroupeDroit> groupes;
	
	public List<GroupeDroit> getGroupes() {
		return groupes;
	}
	public void setGroupes(List<GroupeDroit> groupes) {
		this.groupes = groupes;
	}
	public Long getIdDroit() {
		return idDroit;
	}
	public void setIdDroit(Long idDroit) {
		this.idDroit = idDroit;
	}
	public String getNomDroit() {
		return nomDroit;
	}
	public void setNomDroit(String nomDroit) {
		this.nomDroit = nomDroit;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Droit(String nomDroit, String action) {
		super();
		this.nomDroit = nomDroit;
		this.action = action;
	}
	public Droit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
