package com.ecole.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecole.beans.Etudiant;
import com.ecole.beans.Person;
import com.ecole.beans.Professeur;

public interface PersonRepository extends JpaRepository<Person, Long>{
	
	//professeur queries
	@Query("select p from Professeur p join p.etudiants e where e.id= :x")
	public List<Professeur> findStudentHasProf(@Param("x") Long id);
	
	@Query("select p from Professeur p")
	public List<Professeur> findAllProfs();
	
	@Query("select p from Professeur p where p.id= :x")
	public Professeur findProfById(@Param("x") Long id);
	
	
	//student queries
	@Query("select e from Etudiant e join e.professeurs p where p.id= :x")
	public List<Etudiant> findProfsStudent(@Param("x") Long id);
	
	@Query("select e from Etudiant e")
	public List<Etudiant> findAllStudents();
	
	@Query("select e from Etudiant e where e.id= :x")
	public Etudiant findStudentById(@Param("x") Long id);
	
	//find User By email
	
	public Optional<Person> findByEmail(String email);
	
}
