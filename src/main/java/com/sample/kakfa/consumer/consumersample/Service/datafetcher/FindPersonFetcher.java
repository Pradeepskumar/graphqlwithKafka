package com.sample.kakfa.consumer.consumersample.Service.datafetcher;

import com.sample.kakfa.consumer.consumersample.model.Person;
import com.sample.kakfa.consumer.consumersample.respository.PersonRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import javax.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindPersonFetcher implements DataFetcher<Person> {

  @Autowired
  PersonRepository personRepository;

  @Override
  public Person get(DataFetchingEnvironment dataFetchingEnvironment) {

    String id = dataFetchingEnvironment.getArgument("id");
    return personRepository.findById(id).get();
  }
}
