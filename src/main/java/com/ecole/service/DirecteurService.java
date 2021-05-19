package com.ecole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecole.beans.Directeur;
import com.ecole.beans.Etudiant;
import com.ecole.beans.Professeur;
import com.ecole.dao.PersonRepository;

@Service
public class DirecteurService implements IDirecteurService {
	@Autowired
	private PersonRepository personRepository;

	@Override
	public Etudiant addEtudiant(Etudiant etudiant) {
		return personRepository.save(etudiant);
	}

	@Override
	public Professeur addProf(Professeur prof) {
		return personRepository.save(prof);
	}

	@Override
	public List<Professeur> allProfs() {
		return personRepository.findAllProfs();
	}

	@Override
	public List<Etudiant> allStudents() {
		return personRepository.findAllStudents();
	}

	@Override
	public Professeur profById(Long id) {
		return personRepository.findProfById(id);
	}

	@Override
	public Etudiant studentById(Long id) {
		return personRepository.findStudentById(id);
	}

	@Override
	public void deleteEtudiant(Etudiant e) {
		personRepository.delete(e);
	}

	@Override
	public Directeur directeur(String email) {
		return (Directeur) personRepository.findByEmail(email).get();
	}

}
