package com.ecole;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.ecole.beans.Directeur;
import com.ecole.beans.Etudiant;
import com.ecole.beans.Professeur;
import com.ecole.dao.PersonRepository;

@SpringBootApplication
public class GestionEcoleApplication implements CommandLineRunner{

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionEcoleApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		System.out.println("***************************************");
		System.out.println("password: 1234 = "+ passwordEncoder.encode("1234"));
		System.out.println("***************************************");
		/*
		Etudiant e1 = new Etudiant("darrazi", "anas");
		Etudiant e2 = new Etudiant("saouab", "mouad");
		Etudiant e3 = new Etudiant("darrazi", "ilyas");
		Etudiant e4 = new Etudiant("nadi", "ahmed");
				
		Professeur p1 = new Professeur("fihri", "mohammed");
		Professeur p2 = new Professeur("khalid", "khalid");
		Professeur p3 = new Professeur("elhaki", "rachid");
		Professeur p4 = new Professeur("cherkaoui", "hamza");
		
		e1.getProfesseurs().add(p1); e1.getProfesseurs().add(p2); e1.getProfesseurs().add(p4);
		e2.getProfesseurs().add(p3); e2.getProfesseurs().add(p4);
		e3.getProfesseurs().add(p1); e3.getProfesseurs().add(p2);

		p1.getEtudiants().add(e1);p1.getEtudiants().add(e3);
		p1.getEtudiants().add(e2);p1.getEtudiants().add(e4);
		
		personRepository.save(e1);
		personRepository.save(e2);
		personRepository.save(e3);
		personRepository.save(e4);
		
		personRepository.save(p1);
		personRepository.save(p2);
		personRepository.save(p3);
		personRepository.save(p4);
		
		personRepository.save(new Directeur("chihaja", "aziz"));
		
		personRepository.findStudentHasProf(e1.getId()).forEach(prof->{
			System.out.println("nom_prof "+ prof.getNom());
			System.out.println("prenom_prof "+ prof.getPrenom());
			System.out.println("-----------------------------------------");
		});
		*/
	}

}
