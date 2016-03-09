package com.empsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empsi.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>{

}
