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
    }


}
