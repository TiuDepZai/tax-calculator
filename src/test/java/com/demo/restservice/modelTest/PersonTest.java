package com.demo.restservice.modelTest;

import com.demo.restservice.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.client.ExpectedCount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;


public class PersonTest {
    @Test
    public void testPersonConstructor() {
        UUID id = UUID.randomUUID();
        String name = "John Doe";
        int annualSalary = 50000;
        double superRate = 0.10;
        String payPeriod = "01/Mar/2024 - 31/Mar/2024";

        Person person = new Person(id, name, annualSalary, superRate, payPeriod);

        // Verify constructor initializes fields correctly
        assertEquals(id, person.getId());
        assertEquals(name, person.getName());
        assertEquals(annualSalary, person.getAnnualSalary());
        assertEquals(superRate, person.getSuperRate());
        assertEquals(31, person.getPayPeriod()); // Assuming pay period is March 2024
    }

    @Test
    public void testGetDaysWorked() {
        Person person = new Person(UUID.randomUUID(), "John Doe", 50000, 0.10, "01/Mar/2024 - 31/Mar/2024");

        // Test the getDaysWorked method
        int expectedDaysWorked = 31;
        int actualDaysWorked = person.getPayPeriod();
        assertEquals(expectedDaysWorked, actualDaysWorked);
    }
}

