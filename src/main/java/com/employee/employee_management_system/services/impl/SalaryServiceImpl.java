package com.employee.employee_management_system.services.impl;

import com.employee.employee_management_system.model.Employee;
import com.employee.employee_management_system.model.SalaryRecord;
import com.employee.employee_management_system.repository.EmployeeRepository;
import com.employee.employee_management_system.repository.SalaryRepository;
import com.employee.employee_management_system.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {
    private SalaryRepository salaryRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public SalaryServiceImpl(SalaryRepository salaryRepository, EmployeeRepository employeeRepository){
        this.salaryRepository = salaryRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void paySalary(Long id, SalaryRecord salaryRecord) {
        Employee employee = employeeRepository.findById(id).get();
        System.out.println(employee.getFirstName());
        System.out.println(employee.getEmployeeId());
        SalaryRecord newSalaryRecord = new SalaryRecord();
        newSalaryRecord.setSalary(salaryRecord.getSalary());
        newSalaryRecord.setEmployee(employee);
        salaryRepository.save(newSalaryRecord);
    }

    @Override
    public List<SalaryRecord> getEmployeeSalaries(Long id) {
        Employee employee = employeeRepository.findById(id).get();
//        Pageable pageable = new PageRequest(0, 10, Sort.Direction.ASC, "publicationDate");
//        Page<News> topPage = newsRepository.findByPublicationDate(id, pageable);
        return salaryRepository.findAllByEmployeeOrderByDateDesc(employee);
    }
}
