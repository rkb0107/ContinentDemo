package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.ContinentEntity;
 
@Repository
public interface ContinentRepository extends JpaRepository<ContinentEntity, Long> {
}
