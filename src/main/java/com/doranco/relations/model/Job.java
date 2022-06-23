package com.doranco.relations.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Job implements Serializable  {
	//serializable est obligatoire pour lire les dépendence
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String titre;
	@Column(nullable = false ,length = 200)
	private String description;
	@Column(nullable = false ,length = 200)
	private String departement;
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "job")
	// si la clé primaire migre vers la table fille => "mappedBy" au niveau de la classe mére
private Utilisateur user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Job(String titre, String description, String departement, Utilisateur user) {
		super();
		this.titre = titre;
		this.description = description;
		this.departement = departement;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", titre=" + titre + ", description=" + description + ", departement=" + departement
				+ "]";
	}
	
	
	
	
	
}
