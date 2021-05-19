package com.ecole.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecole.beans.Cours;

public interface CoursRepository extends JpaRepository<Cours, Long>{
	@Query("select c from Cours c where c.prof.id= :x")
	public List<Cours> findCoursByProf(@Param("x") Long id);
}
