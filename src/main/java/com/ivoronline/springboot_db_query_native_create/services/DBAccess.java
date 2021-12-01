package com.ivoronline.springboot_db_query_native_create.services;

import com.ivoronline.springboot_db_query_native_create.entities.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class DBAccess {

  @PersistenceContext EntityManager entityManager;

  //================================================================
  // SELECT PERSON
  //================================================================
  public Person selectPerson() {

    //CREATE QUERY
    String select = "SELECT * FROM Person WHERE name = :name AND age = :age";
    Query  query  = entityManager.createNativeQuery(select, Person.class);
           query.setParameter("name", "John");
           query.setParameter("age" , 20);

    //SELECT PERSON
    Person person = (Person) query.getSingleResult();

    //RETURN PERSON
    return person;

  }

  //================================================================
  // INSERT PERSON
  //================================================================
  @Transactional
  public Integer insertPerson() {

    //CREATE QUERY
    String insert = "INSERT INTO PERSON (name, age) VALUES (:name, :age)";
    Query  query  = entityManager.createNativeQuery(insert);
           query.setParameter("name", "John");
           query.setParameter("age" , 20);

    //INSERT PERSON
    Integer insertedRecords = query.executeUpdate();

    //RETURN NUMBER OF INSERTED RECORDS
    return insertedRecords;

  }

  //================================================================
  // UPDATE PERSON
  //================================================================
  @Transactional
  public Integer updatePerson() {

    //CREATE QUERY
    String update = "UPDATE PERSON SET AGE = :newAge WHERE NAME = :name";
    Query  query  = entityManager.createNativeQuery(update);
           query.setParameter("name"  , "John");
           query.setParameter("newAge", 200);

    //INSERT PERSON
    Integer updatedRecords = query.executeUpdate();

    //RETURN NUMBER OF INSERTED RECORDS
    return updatedRecords;

  }

  //================================================================
  // DELETE PERSON
  //================================================================
  @Transactional
  public Integer deletePerson() {

    //CREATE QUERY
    String delete = "DELETE FROM PERSON WHERE NAME = :name";
    Query  query  = entityManager.createNativeQuery(delete);
           query.setParameter("name"  , "John");

    //INSERT PERSON
    Integer deletedRecords = query.executeUpdate();

    //RETURN NUMBER OF INSERTED RECORDS
    return deletedRecords;

  }

}
