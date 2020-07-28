package com.sample.kakfa.consumer.consumersample.Service;

import com.sample.kakfa.consumer.consumersample.DTO.User;
import com.sample.kakfa.consumer.consumersample.model.Person;
import com.sample.kakfa.consumer.consumersample.respository.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GraphDBService {

  @Autowired
  UserRepository userRepository;

  public User getAllValues(String Name){

    User allUserValue = userRepository.findAllByName(Name);
return allUserValue;
  }

}
