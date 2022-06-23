package com.doranco.relations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.doranco.relations.model.Job;
import com.doranco.relations.model.Tache;
import com.doranco.relations.model.Utilisateur;
import com.doranco.relations.repo.JobRepository;
import com.doranco.relations.repo.TacheRepository;
import com.doranco.relations.repo.UtilisateurRepository;

@SpringBootApplication
public class Exercicej4Application implements CommandLineRunner {
@Autowired
UtilisateurRepository utilisateurRepository;
@Autowired
TacheRepository tacheRepository;
@Autowired
JobRepository jobRepository;

	public static void main(String[] args) {
		SpringApplication.run(Exercicej4Application.class, args);
		
		// permet l'exécution du projet spring et de démarer les serveurs
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Job jb=jobRepository.save(new Job("teste", "testing", "aucun", null));
		Job jb2=jobRepository.save(new Job("teste2", "testingnew", "new", null));

		Utilisateur user1= utilisateurRepository.save(new Utilisateur("khalil@gmail.com", "khalil", "lakhdhar", "cité el amel",null,jb));
		Utilisateur user2= utilisateurRepository.save(new Utilisateur("mail@gmail.com", "second", "user", "Paris",null,jb2));
		Tache t1=tacheRepository.save(new Tache("t1", "t1des", user1));
		Tache t2=tacheRepository.save(new Tache("t2", "t2des", user1));
		Tache t3=tacheRepository.save(new Tache("t3", "t3des", user2));
		List<Tache> taches=new ArrayList<Tache>();
		taches.add(t1);
		taches.add(t2);
		List<Tache> taches2=new ArrayList<Tache>();
		taches2.add(t2);
		taches2.add(t3);
		user1.setTacheList(taches);
		user2.setTacheList(taches2);
		utilisateurRepository.save(user1);
		utilisateurRepository.save(user2);
		utilisateurRepository.findAll().forEach(us->{
			System.out.println(us);
			us.getTacheList().forEach(t->{
				System.out.println(t.toString());
			});
		});
		
	}

}
