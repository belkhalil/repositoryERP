package com.empsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empsi.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long>{

}
