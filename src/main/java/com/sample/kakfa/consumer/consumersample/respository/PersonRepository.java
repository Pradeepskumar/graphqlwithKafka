package com.sample.kakfa.consumer.consumersample.respository;


import com.sample.kakfa.consumer.consumersample.model.Person;
import graphql.schema.DataFetcher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {

  //DataFetcher<Object> findByName(String name);

  // Person findByName(String name);
}
