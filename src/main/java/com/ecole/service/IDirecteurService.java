package com.ecole.service;

import java.util.List;

import com.ecole.beans.Directeur;
import com.ecole.beans.Etudiant;
import com.ecole.beans.Professeur;

public interface IDirecteurService {
	public Etudiant addEtudiant(Etudiant etudiant);
	public Professeur addProf(Professeur prof);
	public List<Professeur> allProfs();
	public List<Etudiant> allStudents();
	public Professeur profById(Long id);
	public Etudiant studentById(Long id);
	public void deleteEtudiant(Etudiant e);
	public Directeur directeur(String email);
}
