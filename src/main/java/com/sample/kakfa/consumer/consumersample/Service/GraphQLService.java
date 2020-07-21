package com.sample.kakfa.consumer.consumersample.Service;

import com.sample.kakfa.consumer.consumersample.Service.datafetcher.AllPersonFetcher;
import com.sample.kakfa.consumer.consumersample.Service.datafetcher.FindPersonFetcher;
import com.sample.kakfa.consumer.consumersample.model.Person;
import com.sample.kakfa.consumer.consumersample.respository.PersonRepository;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import java.io.File;
import java.io.IOException;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class GraphQLService {

  @Value("classpath:person.graphqls")
  private Resource resource;


  private GraphQL graphql;

  @Autowired
  PersonRepository personRepository;
  @Autowired
  private AllPersonFetcher allPersonFetcher;
  @Autowired
  private FindPersonFetcher findPersonFetcher;


  @PostConstruct
  public void loadSchema() throws IOException {
    // load data
   // loadDataIntoHSQL(person);

    //get the schema
    File schemaFile =  resource.getFile();
    //parse the schema and load into type definition registry which is used graph ql
    TypeDefinitionRegistry registry = new SchemaParser().parse(schemaFile);
    //runtime wiring the schema
    RuntimeWiring wiring = buildWiring();
    GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(registry,wiring);
    graphql = GraphQL.newGraphQL(schema).build();
  }

  public void loadDataIntoHSQL(Person person) {
    personRepository.save(person);
  }

  private RuntimeWiring buildWiring() {
    return RuntimeWiring.newRuntimeWiring()
                .type("Query",typeWriting ->
                  typeWriting
                      .dataFetcher("allPerson",allPersonFetcher)
                      .dataFetcher("person",findPersonFetcher))
                      .build();

  }
  public GraphQL getGraphql(){
    return graphql;
  }

}
