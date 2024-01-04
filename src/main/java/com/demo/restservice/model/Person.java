package com.demo.restservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.UUID;

public class Person
{
    private final UUID id;

    private final String name;
    private int annualSalary;
    private double superRate;
    private String payPeriod;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name,
                  @JsonProperty("annualSalary") int annualSalary,
                  @JsonProperty("superRate") double superRate,
                  @JsonProperty("payPeriod") String payPeriod
    )

    {
        this.id = id;
        this.name = name;
        this.annualSalary = annualSalary;
        this.superRate = superRate;
        this.payPeriod = payPeriod;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public int getAnnualSalary() {return annualSalary; }
    public double getSuperRate() {return superRate; }
    public String getPayPeriod() {return payPeriod; }
    public int getDaysWorked(){
        DateTimeFormatter df = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("d/MMM/yyyy")
                .toFormatter(Locale.ENGLISH);

        String[] input = payPeriod.split("-");

        LocalDate d1 = LocalDate.parse(input[0].trim(),df);
        LocalDate d2 = LocalDate.parse(input[1].trim(),df);


        // Calculate the number of days between the two dates
        return (int)ChronoUnit.DAYS.between(d1,d2) + 1;
    }

    public double grossIncome(){
        return Math.round((double)(annualSalary/12) );
    }
    public double incomeTax(){
        if (annualSalary>=0 && annualSalary<=18200){
            return 0;
        }
        else if(annualSalary>=18201 && annualSalary<=37000){
            return Math.round(((annualSalary-18200)*0.19)/12);
        }
        else if(annualSalary>=37001 && annualSalary<=87000){
            return Math.round((3572 + ((annualSalary-37000)*0.325))/12);
        }
        else if(annualSalary>=87001 && annualSalary<=180000){
            return Math.round((19822 + ((annualSalary-87000)*0.37))/12);
        }
        else if(annualSalary>=180001 ){
            return Math.round((54232 + ((annualSalary-180000)*0.45))/12);
        }
        else{
            System.out.println("Incorrect input");
            return -1;
        }
    }
    public int netIncome(){
        return (int)grossIncome()- (int)incomeTax();
    }
    public int superRate(){
        return (int)Math.round(grossIncome() * (double) superRate);
    }
    public Response generatedResponse(){
        Response customResponse = new Response();
        customResponse.setName(name);
        customResponse.setPayPeriod(payPeriod);
        customResponse.setGrossIncome((int) grossIncome());
        customResponse.setIncomeTax((int) incomeTax());
        customResponse.setNetIncome(netIncome());
        customResponse.setSuperAmount(superRate());

        return customResponse;
    }
}
