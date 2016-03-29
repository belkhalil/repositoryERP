package com.empsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empsi.entities.Formation;
import com.empsi.entities.FormationContinu;

public interface FormationContinueRepository extends JpaRepository<FormationContinu, Long>{

}
