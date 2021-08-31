package com.example.demo.web;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Scholar;
import com.example.demo.service.ScholarService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/scholar")
public class ScholarController {

  Logger logger = LoggerFactory.getLogger(getClass());
  @Autowired
  public ScholarService scholarSrv;

  @PostMapping
  public HttpEntity<Scholar> addScholar(@RequestBody Scholar scholar){
    Scholar res;
    logger.info("Request body:", scholar);
    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    if(scholarSrv.addScholar(scholar)){
      status = HttpStatus.CREATED;
      res = scholar;
    }
    else 
      res = new Scholar();
    return new ResponseEntity<>(res, status);
  }

  @GetMapping
  public HttpEntity<List<Scholar>> listAllScholar(){

    HttpStatus status = HttpStatus.OK;
    List<Scholar> res = scholarSrv.getAllScholars();
    return new ResponseEntity<List<Scholar>>(res, status);

  }

  @GetMapping("/{id}")
  public HttpEntity<Scholar> getScholarById(@PathVariable long id){
    logger.info("Id:", id);
    HttpStatus status = HttpStatus.NOT_FOUND;
    Optional<Scholar> opt = scholarSrv.getScholarById(id);
    Scholar res = new Scholar();
    if(opt.isPresent()){
      res = opt.get();
      status = HttpStatus.OK;
    }
    return new ResponseEntity<>(res, status);
  }

  
}
