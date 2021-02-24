package com.employee.employee_management_system.services.impl;

import com.employee.employee_management_system.model.SalaryRecord;
import com.employee.employee_management_system.repository.SalaryRepository;
import com.employee.employee_management_system.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SalaryServiceImpl implements SalaryService {
    private SalaryRepository salaryRepository;

    @Autowired
    public SalaryServiceImpl(SalaryRepository salaryRepository){
        this.salaryRepository = salaryRepository;
    }

    @Override
    public void paySalary(SalaryRecord salaryRecord) {
        salaryRepository.save(salaryRecord);
    }
}
