package com.empsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empsi.entities.users.Administrateur;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Long>{

}
