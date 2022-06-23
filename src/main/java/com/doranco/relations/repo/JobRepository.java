package com.doranco.relations.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doranco.relations.model.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {

}
