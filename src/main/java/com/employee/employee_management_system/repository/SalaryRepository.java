package com.employee.employee_management_system.repository;

import com.employee.employee_management_system.model.SalaryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<SalaryRecord, Double> {
}
