package com.ecole.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("etudiant")
@Data @NoArgsConstructor
public class Etudiant extends Person implements Serializable{

	public Etudiant(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}

	@ManyToMany
	@JoinTable(
			name = "professeur_etudiant",
			joinColumns = @JoinColumn(name= "etudiant_id"),
			inverseJoinColumns = @JoinColumn(name= "professeur_id")
			)
	private List<Professeur> professeurs=new ArrayList<Professeur>();
	
}
