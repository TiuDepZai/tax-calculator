package com.demo.restservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.demo.restservice.dao.PersonDao;
import com.demo.restservice.model.Person;
import com.demo.restservice.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonDao personDao;
    private final List<Person> people = new ArrayList<>();
    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao){
        this.personDao = personDao;
    }
    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }
    public List<Response> getAllResponses(){
        List<Response> Responses = new ArrayList<>();
        for (Person person : people){
            Responses.add(person.generatedResponse());
        }
        return Responses;
    }
    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }
    public Optional<Person> getPersonById(UUID id){

        return personDao.selectedPersonById(id);
    }
    public int deletePerson(UUID id){

        return personDao.deletePersonById(id);
    }
    public int updatePerson(UUID id, Person newPerson){

        return personDao.updatePersonById(id, newPerson);
    }
}
