package com.ecole.beans;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",length = 10,discriminatorType = DiscriminatorType.STRING)
public abstract class Person implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pers")
	private Long id;
	@Column(length = 10)
	private String cin;
	@Column(length = 20)
	@NotEmpty
	private String nom;
	@Column(length = 20)
	@NotEmpty
	private String prenom;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate dateNaissance;
	@Column(length = 40,unique = true)
	@NotEmpty @Email
	private String email;
	@NotEmpty
	private String password;
	@Column(length = 10)
	@Size(min = 10 ,max = 10)
	private String tele;
	public Person(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	

}
