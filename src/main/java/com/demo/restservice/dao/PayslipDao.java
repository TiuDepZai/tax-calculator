package com.demo.restservice.dao;

import com.demo.restservice.model.Payslip;
import com.demo.restservice.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PayslipDao {
    int insertPayslip(Person person, Payslip payslip);
    List<Payslip> selectAllPayslip();

    Optional<Payslip> selectedPayslipById(UUID id);
    int deletePayslipById(UUID id);
    int updatePayslipById(Person person, Payslip payslip);
}
