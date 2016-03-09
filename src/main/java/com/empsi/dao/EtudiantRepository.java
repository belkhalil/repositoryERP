package com.empsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empsi.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{

}
