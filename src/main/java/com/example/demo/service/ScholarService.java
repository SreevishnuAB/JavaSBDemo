package com.example.demo.service;

import com.example.demo.repository.ScholarRepository;
import com.example.demo.model.Scholar;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScholarService {
  Logger logger = LoggerFactory.getLogger(ScholarService.class);
  
  @Autowired
  public ScholarRepository scholarRepository;

  public boolean addScholar(Scholar scholar){
    try {
      scholarRepository.save(scholar);
      return true;
    } catch (Exception e) {
      logger.error("Something went wrong", e);
      return false;
    }
  }

  public List<Scholar> getAllScholars(){
    List<Scholar> list;
    try {
      list = scholarRepository.findAll();
    } catch (Exception e) {
      logger.error("Something went wrong", e);;
      list = new ArrayList<Scholar>();
    }
    return list;
  }

  public boolean deleteScholar(long id){
    try {
      scholarRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      logger.error("Something went wrong", e);
      return false;
    }
  }

  public List<Scholar> getScholarsByBatch(String batch){
    List<Scholar> list;
    try{
      list = scholarRepository.findByBatch(batch);
    }
    catch(Exception e){
      logger.error("Something went wrong:", e);
      list = new ArrayList<Scholar>();
    }
    return list;
  }

  public Optional<Scholar> getScholarById(long id){
    try {
      return scholarRepository.findById(id);

    } catch (Exception e) {
      //TODO: handle exception
      return Optional.empty();
    }
  }

}
