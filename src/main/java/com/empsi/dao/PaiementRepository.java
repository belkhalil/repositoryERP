package com.empsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empsi.entities.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {

}
