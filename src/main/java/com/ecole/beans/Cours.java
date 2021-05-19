package com.ecole.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Cours implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 5)
	private String salle;
	private LocalDate dateCours;
	private LocalTime heureDebut;
	private LocalTime heureFin;
	@ManyToOne
	private Matiere matiere;
	@ManyToOne
	@JoinColumn(name = "prof_id")
	private Professeur prof;

}
