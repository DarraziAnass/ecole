package com.ecole.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecole.beans.Matiere;

public interface MatiereRepository extends JpaRepository<Matiere, Long>{

}
