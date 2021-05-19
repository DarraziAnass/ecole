package com.ecole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecole.beans.Cours;
import com.ecole.beans.Etudiant;
import com.ecole.beans.Professeur;
import com.ecole.dao.CoursRepository;
import com.ecole.dao.PersonRepository;

@Service
public class EtudiantService implements IEtudiantService {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private CoursRepository coursRepository;

	@Override
	public List<Professeur> myProfs(Long etudiant) {
		return personRepository.findStudentHasProf(etudiant);
	}

	@Override
	public List<Cours> myCourses() {
		return coursRepository.findAll();
	}

	@Override
	public Etudiant etudiant(String email) {
		return (Etudiant) personRepository.findByEmail(email).get();
	}

}
