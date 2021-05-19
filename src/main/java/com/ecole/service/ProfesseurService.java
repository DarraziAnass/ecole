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
public class ProfesseurService implements IProfesseurService {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private CoursRepository coursRepository;

	@Override
	public List<Etudiant> myStudents(Long id) {
		return personRepository.findProfsStudent(id);
	}

	@Override
	public List<Cours> myCourses(Long id) {
		return coursRepository.findCoursByProf(id);
	}

	@Override
	public Cours addCours(Cours cours) {
		return coursRepository.save(cours);
	}

	@Override
	public Professeur professeur(String email) {
		return (Professeur) personRepository.findByEmail(email).get();
	}

}
