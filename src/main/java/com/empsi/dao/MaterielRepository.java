package com.empsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empsi.entities.Materiel;

public interface MaterielRepository extends JpaRepository<Materiel, Long> {

}
