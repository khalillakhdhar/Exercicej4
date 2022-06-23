package com.doranco.relations.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doranco.relations.model.Tache;

public interface TacheRepository extends JpaRepository<Tache, Integer> {

}
