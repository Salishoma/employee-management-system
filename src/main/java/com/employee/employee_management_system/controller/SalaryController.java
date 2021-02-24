package com.employee.employee_management_system.controller;


import com.employee.employee_management_system.model.Employee;
import com.employee.employee_management_system.model.SalaryRecord;
import com.employee.employee_management_system.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SalaryController {

    private SalaryService salaryService;

    @Autowired

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }


}
