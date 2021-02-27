package com.employee.employee_management_system.services;

import com.employee.employee_management_system.model.SalaryRecord;

import java.util.Date;
import java.util.List;

public interface SalaryService {
    void paySalary(Long id, SalaryRecord salaryRecord);
    List<SalaryRecord> getEmployeeSalaries(Long id);
}
