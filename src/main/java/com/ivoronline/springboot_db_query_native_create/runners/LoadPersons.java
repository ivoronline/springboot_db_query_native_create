package com.ivoronline.springboot_db_query_native_create.runners;

import com.ivoronline.springboot_db_query_native_create.entities.Person;
import com.ivoronline.springboot_db_query_native_create.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Order(1)
public class LoadPersons implements CommandLineRunner {

  @Autowired
  PersonRepository personRepository;

  @Override
  @Transactional
  public void run(String... args) throws Exception {
    personRepository.save(new Person("John" , 20));
    personRepository.save(new Person("John" , 21));
    personRepository.save(new Person("Bill" , 30));
    personRepository.save(new Person("Nancy", 40));
    personRepository.save(new Person("Susan", 50));
  }

}

