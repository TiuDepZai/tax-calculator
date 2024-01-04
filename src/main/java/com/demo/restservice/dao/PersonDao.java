package com.demo.restservice.dao;

import com.demo.restservice.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id, Person person);
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID()   ;
        return insertPerson(id, person);
    }
    List<Person> selectAllPeople();

    Optional<Person> selectedPersonById(UUID id);
    int deletePersonById(UUID id);
    int updatePersonById(UUID id, Person person);
}
