package com.empsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empsi.entities.Semestre;

public interface SemestreRepository extends JpaRepository<Semestre, Long>{	
	
}
