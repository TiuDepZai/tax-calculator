package com.demo.restservice.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import com.demo.restservice.dao.PayslipDao;
import com.demo.restservice.dao.PersonDao;
import com.demo.restservice.model.Payslip;
import com.demo.restservice.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonDao personDao;
    private final PayslipDao payslipDao;
    private final List<Person> people = new ArrayList<>();
    private final List<Payslip> payslips = new ArrayList<>();
    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao, PayslipDao payslipDao){
        this.personDao = personDao;
        this.payslipDao = payslipDao;
    }

    public int addPerson(Person person) {
        Payslip payslip = generatePayslip(person);
        payslipDao.insertPayslip(person,payslip);
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }
    public Optional<Person> getPersonById(UUID id){

        return personDao.selectedPersonById(id);
    }
    public Optional<Payslip> getPaySlipById(UUID id){

        return payslipDao.selectedPayslipById(id);

    }
    public int deletePerson(UUID id){

        return personDao.deletePersonById(id);
    }
    public int updatePerson(UUID id, Person newPerson){

        return personDao.updatePersonById(id, newPerson);
    }

    public Payslip generatePayslip(Person person){
        int salary = person.getAnnualSalary();
        int tax = getTax(salary);
        int netIncome = netIncome(salary,tax);
        double superRate = person.getSuperRate();
        if (tax == -1){
            System.out.println("Something went wrong");
        }
        return new Payslip(person,person.getPayPeriod(),tax,netIncome,superRate);
    }

    public int getTax(int Income){
        try (
                InputStream inputStream = getClass().getClassLoader().getResourceAsStream("taxCode.json")) {
                if (inputStream != null){
                    ObjectMapper objectMapper = new ObjectMapper();
                    List<Map<String,Object>> taxThresholds = objectMapper.readValue(inputStream, List.class);

                    for (Map<String, Object> threshold : taxThresholds){
                        int thresHoldValue = (int) threshold.get("threshold");
                        double percentage = (double) threshold.get("percentage");
                        double initial = (double) threshold.get("initial");

                        if (Income <= thresHoldValue){
                            System.out.println("Income is below or equal to threshold: " + thresHoldValue);
                            System.out.println("Apply percentage:" +percentage);
                            System.out.println("Initial tax: " + initial);
                            return (int)Math.round(initial+((Income - thresHoldValue)*percentage));
                        }
                    }
                }
                return -1;

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


//
//    public double grossIncome(){
//        return Math.round((double)(annualSalary/12) );
//
    public int netIncome(double income, int incomeTax){
        return (int)Math.round(income/12)- incomeTax;
    }
//    public int superRate(){
//        return (int)Math.round(grossIncome() * (double) superRate);
//    }

}
