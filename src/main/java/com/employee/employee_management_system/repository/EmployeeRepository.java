package com.employee.employee_management_system.repository;

import com.employee.employee_management_system.model.Employee;
import com.employee.employee_management_system.model.SalaryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);

    Optional<Employee> findByEmailAndPassword(String email, String password);

//    List<SalaryRecord> findEmployeeSalaryRecord(Long employeeId, List<SalaryRecord> salaryHistory);
}
