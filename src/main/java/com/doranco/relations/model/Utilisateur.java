package com.doranco.relations.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true, nullable = false)
	@Email
	private String email;
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;

	@Column(nullable = false)
	private String adresse;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.EAGER)
	// Eager=> lire la liste des élément dépendent au moment de chargement de l'instance
	// Eager est idéale si la classe en relation n'a aucune autre dépendance
	// lazy => met un delai d'attente pour charger les données
	// lazy est idéale pour attendre le chargement d'une liste de classes fille en cas de dépendences imbriqué
	// onetomany => List
	@JsonManagedReference

	private List<Tache> tacheList;
	@OneToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "job_id",nullable = false)
	
	//la classe fille contient le JoinColumn et ne contient pas le mappedBy
	private Job job;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Tache> getTacheList() {
		return tacheList;
	}

	public void setTacheList(List<Tache> tacheList) {
		this.tacheList = tacheList;
	}

	public Utilisateur(@Email String email, String nom, String prenom, String adresse, List<Tache> tacheList, Job job) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tacheList = tacheList;
		this.job = job;
	}

	public Utilisateur() {
		super();
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", email=" + email + ", nom=" + nom + ", prenom=" + prenom + ", adresse="
				+ adresse + ", job=" + job + "]";
	}


	
	
}
