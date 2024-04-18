package com.demo.restservice.modelTest;

import com.demo.restservice.model.Payslip;
import com.demo.restservice.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.client.ExpectedCount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;


public class PayslipTest {
    @Test
    public void testPayslipConstructorAndGetters() {
        // Create a Person instance
        Person person = new Person(UUID.randomUUID(), "John Doe",50000,0.1,"01/Mar/2024 - 31/Mar/2024");

        // Create a Payslip instance
        int payPeriod = 1;
        int incomeTax = 1000;
        int netIncome = 5000;
        double superRate = 0.1;
        Payslip payslip = new Payslip(person, payPeriod, incomeTax, netIncome, superRate);

        // Test getters
        assertEquals(person, payslip.getPerson());
        assertEquals(payPeriod, payslip.getPayPeriod());
        assertEquals(incomeTax, payslip.getIncomeTax());
        assertEquals(netIncome, payslip.getNetIncome());
        assertEquals(superRate, payslip.getSuperRate());
    }

    @Test
    public void testPayslipSetters() {
        // Create a Person instance
        Person person = new Person(UUID.randomUUID(), "John Doe",50000,0.1,"01/Mar/2024 - 31/Mar/2024");

        // Create a Payslip instance
        Payslip payslip = new Payslip(person, 1, 1000, 5000, 0.1);

        // Test setters
        int newPayPeriod = 2;
        int newIncomeTax = 1500;
        int newNetIncome = 5500;
        double newSuperRate = 0.15;

        payslip.setPayPeriod(newPayPeriod);
        payslip.setIncomeTax(newIncomeTax);
        payslip.setNetIncome(newNetIncome);
        payslip.setSuperRate(newSuperRate);

        assertEquals(newPayPeriod, payslip.getPayPeriod());
        assertEquals(newIncomeTax, payslip.getIncomeTax());
        assertEquals(newNetIncome, payslip.getNetIncome());
        assertEquals(newSuperRate, payslip.getSuperRate());
    }
}
