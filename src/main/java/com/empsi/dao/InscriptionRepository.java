package com.empsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empsi.entities.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription, Long>{

}
