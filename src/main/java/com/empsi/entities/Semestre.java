package com.empsi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Semestre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSemestre;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "YYYY-MMM-dd")
	private Date dateDebut;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "YYYY-MMM-dd")
	private Date dateFin;

	private String description;
	private String nomSemestre;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idNiveau")
	private Niveau niveau;

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public Semestre(Long idSemestre, Date dateDebut, Date dateFin, String description, String nomSemestre) {
		super();
		this.idSemestre = idSemestre;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
		this.nomSemestre = nomSemestre;
	}

	public Semestre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getIdSemestre() {
		return idSemestre;
	}

	public void setIdSemestre(Long idSemestre) {
		this.idSemestre = idSemestre;
	}

	public String getNomSemestre() {
		return nomSemestre;
	}

	public void setNomSemestre(String nomSemestre) {
		this.nomSemestre = nomSemestre;
	}

}
