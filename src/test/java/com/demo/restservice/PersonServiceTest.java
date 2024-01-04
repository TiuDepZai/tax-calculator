package com.demo.restservice;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.demo.restservice.dao.PersonDao;
import com.demo.restservice.model.Person;
import com.demo.restservice.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class PersonServiceTest {
    private PersonService personService;
    private PersonDao personDaoMock;

    @BeforeEach
    void setUp(){
        personDaoMock = mock(PersonDao.class);
        personService = new PersonService(personDaoMock);
    }

    @Test
    void addPerson(){
        UUID id = UUID.randomUUID();
        Person person = new Person(id,"John Smith", 60050,0.09,"01 March-31 March");

        personService.addPerson(person);

        verify(personDaoMock, times(1)).insertPerson(person);
    }
    @Test
    void getAllPeople(){
        UUID id = UUID.randomUUID();
        List<Person> expectedPeople = Collections.singletonList(new Person(id,"John Smith", 60050,0.09,"01 March-31 March"));
        when(personDaoMock.selectAllPeople()).thenReturn(expectedPeople);

        List<Person> actualPeople = personService.getAllPeople();

        assertEquals(expectedPeople, actualPeople);
    }
    // Missing test cases for getPersonById, deletePerson, updatePerson
}
