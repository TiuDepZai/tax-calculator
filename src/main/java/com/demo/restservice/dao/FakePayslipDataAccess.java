package com.demo.restservice.dao;

import com.demo.restservice.model.Payslip;
import com.demo.restservice.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakePayslipDao")
public class FakePayslipDataAccess implements PayslipDao {
    private static List<Payslip> DB = new ArrayList<>();

    @Override
    public int insertPayslip(Person person, Payslip payslip) {
        DB.add(new Payslip(person, payslip.getPayPeriod(), payslip.getIncomeTax(), payslip.getNetIncome(),payslip.getSuperRate()));
        return 1;
    }

    @Override
    public List<Payslip> selectAllPayslip() {
        return null;
    }

    @Override
    public Optional<Payslip> selectedPayslipById(UUID id) {
        return DB.stream()
                .filter(payslip -> payslip.getPerson().getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePayslipById(UUID id) {
        return 0;
    }

    @Override
    public int updatePayslipById(Person person, Payslip payslip) {
        return 0;
    }


}
