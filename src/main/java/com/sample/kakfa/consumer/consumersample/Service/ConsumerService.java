package com.sample.kakfa.consumer.consumersample.Service;


import com.sample.kakfa.consumer.consumersample.model.Person;
import com.sample.kakfa.consumer.consumersample.respository.PersonRepository;
import com.sample.kakfa.consumer.consumersample.DTO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

@Autowired
  GraphQLService graphQLService;

  @KafkaListener(topics = "EXAMPLE_TOPIC",groupId = "group_id")
  public void consume(String message)
  {
    System.out.println(String.format("Message recieved -> %s", message));
  }

  @KafkaListener(topics = "Example_Topic_JSON", groupId = "group_json", containerFactory = "userKafkaListener")
  public void consume(User user) {
    Person person = new Person(user.getId(),user.getName(),user.getAge());
    graphQLService.loadDataIntoHSQL(person);
    System.out.println("Message recieved -> %s" + user);
  }
}
