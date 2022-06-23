package com.doranco.relations.controller;

import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doranco.relations.model.Utilisateur;
import com.doranco.relations.repo.UtilisateurRepository;

@RestController
public class UtilisateurController {
@Autowired
UtilisateurRepository utilisateurRepository;
	
	@GetMapping("/api")
	public List<Utilisateur> findUsers()
	{
		return utilisateurRepository.findAll();
		// avec findall dans un RestController aucun besoin de faire forEach
	}

}
