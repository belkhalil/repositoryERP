package com.empsi.entities.users;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.empsi.entities.Declaration;
import com.empsi.entities.Document;
import com.empsi.entities.Notification;
import com.empsi.entities.ReservationMateriel;
import com.empsi.entities.Statut;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Utilisateur implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="idUtilisateur")
	private Long idUtilisateur;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private String cinUtilisateur;
	private String emailUtilisateur;
	private Date dateNaissance;
	private String villeNaissance;
	private String paysNaissance;
	private String adresseUtilisateur;
	private String telUtilisateur;
	private String telFixUtilisateur;
	private String professionUtilisateur;
	
	@OneToMany(mappedBy="utilisateur")
	private List<Declaration> declarations;
	@OneToMany(mappedBy="utilisateur")
	private List<Diplome> diplomes;
	@OneToMany(mappedBy="utilisateur")
	private List<Statut> statuts;
	@OneToMany(mappedBy="utilisateur")
	private List<Document> documents;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCompte", referencedColumnName= "idCompte")
	private Compte compte;
	
	/*@ManyToMany(fetch = FetchType.LAZY, mappedBy = "membres")
	private List<Club> clubs;*/

	@OneToMany(mappedBy="utilisateur")
	private List<ReservationMateriel> resMateriels;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "notifUser", joinColumns = { 
			@JoinColumn(name = "idUtilisateur", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "idNotification", 
					nullable = false, updatable = false) })
	private List<Notification> notifications;
	
// Generate Constructor using Fields 
	public Utilisateur(String nomUtilisateur, String prenomUtilisateur, String cinUtilisateur, String emailUtilisateur,
			Date dateNaissance, String villeNaissance, String paysNaissance, String adresseUtilisateur,
			String telUtilisateur, String telFixUtilisateur, String professionUtilisateur) {
		super();
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.cinUtilisateur = cinUtilisateur;
		this.emailUtilisateur = emailUtilisateur;
		this.dateNaissance = dateNaissance;
		this.villeNaissance = villeNaissance;
		this.paysNaissance = paysNaissance;
		this.adresseUtilisateur = adresseUtilisateur;
		this.telUtilisateur = telUtilisateur;
		this.telFixUtilisateur = telFixUtilisateur;
		this.professionUtilisateur = professionUtilisateur;
	}
	// Generate Constructor from Super Class 
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	// Generate Getters and Setters
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getCinUtilisateur() {
		return cinUtilisateur;
	}

	public void setCinUtilisateur(String cinUtilisateur) {
		this.cinUtilisateur = cinUtilisateur;
	}

	public String getEmailUtilisateur() {
		return emailUtilisateur;
	}

	public void setEmailUtilisateur(String emailUtilisateur) {
		this.emailUtilisateur = emailUtilisateur;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getVilleNaissance() {
		return villeNaissance;
	}

	public void setVilleNaissance(String villeNaissance) {
		this.villeNaissance = villeNaissance;
	}

	public String getPaysNaissance() {
		return paysNaissance;
	}

	public void setPaysNaissance(String paysNaissance) {
		this.paysNaissance = paysNaissance;
	}

	public String getAdresseUtilisateur() {
		return adresseUtilisateur;
	}

	public void setAdresseUtilisateur(String adresseUtilisateur) {
		this.adresseUtilisateur = adresseUtilisateur;
	}

	public String getTelUtilisateur() {
		return telUtilisateur;
	}

	public void setTelUtilisateur(String telUtilisateur) {
		this.telUtilisateur = telUtilisateur;
	}

	public String getTelFixUtilisateur() {
		return telFixUtilisateur;
	}

	public void setTelFixUtilisateur(String telFixUtilisateur) {
		this.telFixUtilisateur = telFixUtilisateur;
	}

	public String getProfessionUtilisateur() {
		return professionUtilisateur;
	}

	public void setProfessionUtilisateur(String professionUtilisateur) {
		this.professionUtilisateur = professionUtilisateur;
	}

	public List<Declaration> getDeclarations() {
		return declarations;
	}

	public void setDeclarations(List<Declaration> declarations) {
		this.declarations = declarations;
	}

	public List<Diplome> getDiplomes() {
		return diplomes;
	}

	public void setDiplomes(List<Diplome> diplomes) {
		this.diplomes = diplomes;
	}

	public List<Statut> getStatuts() {
		return statuts;
	}

	public void setStatuts(List<Statut> statuts) {
		this.statuts = statuts;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public List<ReservationMateriel> getResMateriels() {
		return resMateriels;
	}

	public void setResMateriels(List<ReservationMateriel> resMateriels) {
		this.resMateriels = resMateriels;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
	
}
