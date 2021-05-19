package com.ecole.service;

import java.util.List;

import com.ecole.beans.Cours;
import com.ecole.beans.Etudiant;
import com.ecole.beans.Professeur;

public interface IProfesseurService {
	public List<Etudiant> myStudents(Long id);
	public List<Cours> myCourses(Long id);
	public Cours addCours(Cours cours);
	public Professeur professeur(String email);
}
