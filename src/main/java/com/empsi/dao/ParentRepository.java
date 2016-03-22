package com.empsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empsi.entities.users.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long>{

}
