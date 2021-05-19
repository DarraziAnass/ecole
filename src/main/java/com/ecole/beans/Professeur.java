package com.ecole.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("professeur")
@Data @NoArgsConstructor
public class Professeur extends Person implements Serializable{

	public Professeur(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}

	@ManyToMany(mappedBy = "professeurs")
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Etudiant> etudiants=new ArrayList<>();
	
	@ManyToMany(mappedBy = "prof")
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Cours> courses=new ArrayList<>();
}
