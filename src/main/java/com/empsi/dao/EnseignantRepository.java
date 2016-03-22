package com.empsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empsi.entities.users.Enseignant;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long>{

}
