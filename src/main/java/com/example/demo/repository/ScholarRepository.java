package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.demo.model.Scholar;

@Repository
public interface ScholarRepository extends JpaRepository<Scholar, Long>{

  List<Scholar> findByBatch(String batch);
  
}
