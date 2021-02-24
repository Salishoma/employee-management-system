package com.employee.employee_management_system.services;

import com.employee.employee_management_system.model.Employee;
import com.employee.employee_management_system.model.SalaryRecord;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Employee findEmployee(Long id);

    Employee findEmployeeByEmail(String email);

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    void deleteEmployeeById(long id);

    Employee getEmployeeByEmailAndPassword(String email, String password);

//    public List<SalaryRecord> getEmployeeSalaryHistory(Employee employee);
}
