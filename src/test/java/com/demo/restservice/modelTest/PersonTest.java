package com.demo.restservice.modelTest;

import static org.junit.jupiter.api.Assertions.*;

import com.demo.restservice.model.Person;
import com.demo.restservice.model.Response;
import com.demo.restservice.service.PersonService;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;
public class PersonTest {
    @Test
    void testGetDaysWorked() {
        Person person = new Person(UUID.randomUUID(), "John Doe", 60000, 0.1, "01/Jan/2023 - 31/Jan/2023");

        int daysWorked = person.getDaysWorked();

        assertEquals(31, daysWorked);
    }

    @Test
    void testGrossIncome() {
        Person person = new Person(UUID.randomUUID(), "Jane Smith", 120000, 0.01, "01/Feb/2023 - 28/Feb/2023");

        double grossIncome = person.grossIncome();

        assertEquals(10000, grossIncome, 0.01);
    }

    @Test
    void testIncomeTax() {
        Person person = new Person(UUID.randomUUID(), "Bob Johnson", 60050, 0.09, "01/Mar/2023 - 31/Mar/2023");

        double incomeTax = person.incomeTax();

        assertEquals(922, incomeTax, 0.01);
    }
    @Test
    public void testGrossIncome1() {
        Person person = new Person(null, "David Rudd", 60050, 0.09, "01 February - 28 February");
        assertEquals(5004, person.grossIncome());
    }

    @Test
    public void testIncomeTax1() {
        Person person = new Person(null, "RyanChen", 120000, 0.1, "01 February - 28 February");
        assertEquals(2669, person.incomeTax());
    }

    @Test
    public void testSuperannuation() {
        Person person = new Person(null, "David Rudd", 60050, 0.09, "01 February - 28 February");
        assertEquals(450, person.superRate());
    }

    @Test
    public void testNetIncome() {
        Person person = new Person(null, "Ryan Chen", 120000, 0.1, "01 February - 28 February");
        assertEquals(7331, person.netIncome());
    }

}

