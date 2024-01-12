package com.demo.restservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;


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
    private int payPeriod;

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
        this.payPeriod = getDaysWorked(payPeriod);
    }
    public int getDaysWorked(String input){
        DateTimeFormatter df = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("d/MMM/yyyy")
                .toFormatter(Locale.ENGLISH);

        String[] splitInput = input.split("-");

        LocalDate d1 = LocalDate.parse(splitInput[0].trim(),df);
        LocalDate d2 = LocalDate.parse(splitInput[1].trim(),df);


        // Calculate the number of days between the two dates
        return (int) ChronoUnit.DAYS.between(d1,d2) + 1;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(int annualSalary) {
        this.annualSalary = annualSalary;
    }

    public double getSuperRate() {
        return superRate;
    }

    public void setSuperRate(double superRate) {
        this.superRate = superRate;
    }

    public int getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(String payPeriod) {

        this.payPeriod = getDaysWorked(payPeriod);
    }
}
