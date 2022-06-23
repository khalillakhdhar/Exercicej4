package com.doranco.relations.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity

public class Tache implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, length = 200)
	private String titre;
	@Column(nullable = false ,length = 200)
	private String description;
	@JsonBackReference

	@ManyToOne(optional = false)
	@JoinColumn(name="id_employee", referencedColumnName = "id")
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
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	public Tache(String titre, String description, Utilisateur user) {
		super();
		this.titre = titre;
		this.description = description;
		this.user = user;
	}
	public Tache() {
		super();
	}
	@Override
	public String toString() {
		return "Tache [id=" + id + ", titre=" + titre + ", description=" + description + "]";
	}

	
	
	
	
	
	
	
}
