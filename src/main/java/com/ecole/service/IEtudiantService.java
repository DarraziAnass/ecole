package com.ecole.service;

import java.util.List;

import com.ecole.beans.Cours;
import com.ecole.beans.Etudiant;
import com.ecole.beans.Professeur;

public interface IEtudiantService {
	public List<Professeur> myProfs(Long etudiant);
	public List<Cours> myCourses();
	public Etudiant etudiant(String email);
}
