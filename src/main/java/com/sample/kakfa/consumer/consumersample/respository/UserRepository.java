package com.sample.kakfa.consumer.consumersample.respository;


import com.sample.kakfa.consumer.consumersample.DTO.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends Neo4jRepository<User,String> {


//  @Query("MATCH (u:User) Return u")
//  String getAllUsers();

 // String findAllByName();
 User findAllByName(@Param("name") String title);
}
