package com.sample.kakfa.consumer.consumersample.Service.datafetcher;

import com.sample.kakfa.consumer.consumersample.model.Person;
import com.sample.kakfa.consumer.consumersample.respository.PersonRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AllPersonFetcher  implements DataFetcher<List<Person>> {


  @Autowired
   PersonRepository personRepository;

  @Override
  public List<Person> get(DataFetchingEnvironment dataFetchingEnvironment) {
    return personRepository.findAll();
  }
}
