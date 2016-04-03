package com.empsi.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Formation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="idFormation")
	private Long idFormation;
	private String nomFormation;
	private String descFormation;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat (pattern="YYYY-MMM-dd")
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat (pattern="YYYY-MMM-dd")
	private Date dateFin;
	
	private double prix;
	
	
	@OneToMany(mappedBy = "formation")
    private List<TypeFormaton> typeFormations;
	
	@OneToMany(mappedBy = "formation")
    private List<Inscription> inscriptions;
	
	@ManyToMany(mappedBy = "formations")
    private List<Module> modules;
	
	
	public List<TypeFormaton> getTypeFormations() {
		return typeFormations;
	}
	public void setTypeFormations(List<TypeFormaton> typeFormations) {
		this.typeFormations = typeFormations;
	}
	public Long getIdFormation() {
		return idFormation;
	}
	public void setIdFormation(Long idFormation) {
		this.idFormation = idFormation;
	}
	public String getNomFormation() {
		return nomFormation;
	}
	public void setNomFormation(String nomFormation) {
		this.nomFormation = nomFormation;
	}
	public String getDescFormation() {
		return descFormation;
	}
	public void setDescFormation(String descFormation) {
		this.descFormation = descFormation;
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
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public List<Inscription> getInscriptions() {
		return inscriptions;
	}
	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}
	public List<Module> getModules() {
		return modules;
	}
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	
	
	public Formation(String nomFormation, String descFormation, Date dateDebut, Date dateFin, double prix) {
		super();
		this.nomFormation = nomFormation;
		this.descFormation = descFormation;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prix = prix;
		
	}
	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
