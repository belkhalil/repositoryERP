package com.empsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empsi.entities.Evaluation;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long>{

}
