package com.sample.kakfa.consumer.consumersample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
@Data
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class User {

  @Id
  private String id;
  private String name;
  private String age;
  private String country;

}
