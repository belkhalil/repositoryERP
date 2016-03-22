package com.empsi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.empsi.entities.users.Utilisateur;

@Entity
public class ReservationMateriel implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idResMateriel;
	private Date dateRes;
	private Date debutRes;
	private Date finRes;
	private Date heureDebut;
	private Date heureFin;
	private  String descReservation;
	@ManyToOne
    @JoinColumn(name = "idUtilisateur")
	private Utilisateur utilisateur;
	@ManyToOne
    @JoinColumn(name = "idMateriel")
	private Materiel materiel;
	private String decision;
	public ReservationMateriel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReservationMateriel(Date dateRes, Date debutRes, Date finRes, Date heureDebut, Date heureFin,
			String descReservation, String decision) {
		super();
		this.dateRes = dateRes;
		this.debutRes = debutRes;
		this.finRes = finRes;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.descReservation = descReservation;
		this.decision = decision;
	}
	public Long getIdResMateriel() {
		return idResMateriel;
	}
	public void setIdResMateriel(Long idResMateriel) {
		this.idResMateriel = idResMateriel;
	}
	public Date getDateRes() {
		return dateRes;
	}
	public void setDateRes(Date dateRes) {
		this.dateRes = dateRes;
	}
	public Date getDebutRes() {
		return debutRes;
	}
	public void setDebutRes(Date debutRes) {
		this.debutRes = debutRes;
	}
	public Date getFinRes() {
		return finRes;
	}
	public void setFinRes(Date finRes) {
		this.finRes = finRes;
	}
	public Date getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}
	public Date getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}
	public String getDescReservation() {
		return descReservation;
	}
	public void setDescReservation(String descReservation) {
		this.descReservation = descReservation;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Materiel getMateriel() {
		return materiel;
	}
	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	
	
}
