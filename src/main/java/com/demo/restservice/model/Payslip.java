package com.demo.restservice.model;

public class Payslip {
    private Person person;
    private int payPeriod;
    private int incomeTax;
    private int netIncome;
    private double superRate;

    public Payslip(Person person, int payPeriod, int incomeTax, int netIncome, double superRate) {
        this.person = person;
        this.payPeriod = payPeriod;
        this.incomeTax = incomeTax;
        this.netIncome = netIncome;
        this.superRate = superRate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(int payPeriod) {
        this.payPeriod = payPeriod;
    }

    public int getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(int incomeTax) {
        this.incomeTax = incomeTax;
    }

    public int getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(int netIncome) {
        this.netIncome = netIncome;
    }

    public double getSuperRate() {
        return superRate;
    }

    public void setSuperRate(double superRate) {
        this.superRate = superRate;
    }

    @Override
    public String toString() {
        return "Payslip{" +
                "person=" + person +
                ", payPeriod=" + payPeriod +
                ", incomeTax=" + incomeTax +
                ", netIncome=" + netIncome +
                ", superRate=" + superRate +
                '}';
    }
}
