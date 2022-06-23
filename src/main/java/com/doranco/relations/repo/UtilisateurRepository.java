package com.doranco.relations.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doranco.relations.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

}
