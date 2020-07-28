package com.sample.kakfa.consumer.consumersample.controller;

import com.sample.kakfa.consumer.consumersample.Service.GraphDBService;
import com.sample.kakfa.consumer.consumersample.Service.GraphQLService;
import com.sample.kakfa.consumer.consumersample.respository.PersonRepository;
import com.sample.kakfa.consumer.consumersample.Service.ConsumerService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consume")
public class ConsumerController {

  private ConsumerService consumerService;
  private PersonRepository personRepository;
  private GraphQLService graphQLService;
  private GraphDBService graphDBService;

  @Autowired
  public ConsumerController(ConsumerService consumerService,PersonRepository personRepository,GraphQLService graphQLService,GraphDBService graphDBService){
    this.consumerService = consumerService;
    this.personRepository = personRepository;
    this.graphQLService = graphQLService;
    this.graphDBService = graphDBService;
  }

  @PostMapping
  public ResponseEntity<Object> getAllPersons(@RequestBody String query) {
   ExecutionResult execution =  graphQLService.getGraphql().execute(query);
    return new ResponseEntity(execution, HttpStatus.OK);
  }


  @GetMapping
  public ResponseEntity getGraphNeo4jDBValues(String Name){
  return new ResponseEntity(graphDBService.getAllValues(Name), HttpStatus.OK);

  }

}
