package com.empsi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class FormationContinu extends Formation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long dure;

	public FormationContinu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FormationContinu(String nomFormation, String descFormation, Date dateDebut, Date dateFin, double prix, typeFormation typeFormation) {
		super(nomFormation, descFormation, dateDebut, dateFin, prix, typeFormation);
		// TODO Auto-generated constructor stub
	}

	public FormationContinu(String nomFormation, String descFormation, Date dateDebut, Date dateFin, double prix,
			Long dure, typeFormation typeFormation) {
		super(nomFormation, descFormation, dateDebut, dateFin, prix, typeFormation);
		this.dure = dure;
	}

	public Long getDure() {
		return dure;
	}

	public void setDure(Long dure) {
		this.dure = dure;
	}
	
	
}
