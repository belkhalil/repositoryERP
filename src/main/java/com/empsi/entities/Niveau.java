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
import javax.persistence.OneToMany;

@Entity
public class Niveau implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idNiveau;
	// bac+1,bac+2...
	private String nomNiveau;
	//deug,licence,master
	private String labelNiveau;
    
	@OneToMany(mappedBy = "niveau")
	private List<Semestre> semestres;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Niveau_formation", joinColumns = {
			@JoinColumn(name = "idNiveau", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "idFormation", nullable = false, updatable = false) })
	private List<Formation> formations;

	public Niveau() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Niveau(String nomNiveau) {
		super();
		this.nomNiveau = nomNiveau;
	}

	public Long getIdNiveau() {
		return idNiveau;
	}

	public void setIdNiveau(Long idNiveau) {
		this.idNiveau = idNiveau;
	}

	public String getNomNiveau() {
		return nomNiveau;
	}

	public void setNomNiveau(String nomNiveau) {
		this.nomNiveau = nomNiveau;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public String getLabelNiveau() {
		return labelNiveau;
	}

	public void setLabelNiveau(String labelNiveau) {
		this.labelNiveau = labelNiveau;
	}

}
