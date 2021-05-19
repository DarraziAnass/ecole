package com.ecole.beans;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("directeur")
@Data @NoArgsConstructor
public class Directeur extends Person implements Serializable{
	
	public Directeur(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}

}
