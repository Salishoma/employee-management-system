package com.employee.employee_management_system.services.impl;

import com.employee.employee_management_system.model.Admin;
import com.employee.employee_management_system.model.Employee;
import com.employee.employee_management_system.model.SalaryRecord;
import com.employee.employee_management_system.repository.EmployeeRepository;
import com.employee.employee_management_system.repository.SalaryRepository;
import com.employee.employee_management_system.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private SalaryRepository salaryRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, SalaryRepository salaryRepository) {
        this.employeeRepository = employeeRepository;
        this.salaryRepository = salaryRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        Employee employee1 = employeeRepository.findByEmail(employee.getEmail());
        if(employee1 == null) {
            return employeeRepository.save(employee);
        } else {
            employee1.setFirstName(employee.getFirstName());
            employee1.setLastName(employee.getLastName());
            employee1.setEmail(employee.getEmail());
            employee1.setPassword(employee.getPassword());
            employee1.setAddress(employee.getAddress());
            employee1.setPhoneNumber(employee.getPhoneNumber());
            return employeeRepository.save(employee1);
        }
    }

    @Override
    public Employee findEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        return employee;
    }

    @Override
    public Employee findEmployeeByEmail(String email) {
        Employee employee = employeeRepository.findByEmail(email);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

//    @Override
//    public void saveEmployee(Employee employee) {
//        employeeRepository.save(employee);
//    }

    @Override
    public void deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee getEmployeeByEmailAndPassword(String email, String password) {
        Optional<Employee> admin = employeeRepository.findByEmailAndPassword(email, password);
        return admin.orElse(null);
    }

    @Override
    public void updateEmployee(Employee employee, Long employeeId) {
        Employee name = employeeRepository.findById(employeeId).get();
        name.setFirstName(employee.getFirstName());
        name.setLastName(employee.getLastName());
        name.setEmail(employee.getEmail());
        employeeRepository.save(name);
    }

    @Override
    public List<SalaryRecord> getEmployeeSalaryHistory(Employee employee){
        return employee.getEmployeeSalaryRecord();

    }
}
