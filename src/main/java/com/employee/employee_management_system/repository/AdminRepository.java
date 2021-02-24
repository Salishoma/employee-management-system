package com.employee.employee_management_system.repository;

import com.employee.employee_management_system.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmailAndPassword(String email, String password);

    Optional<Admin> findByEmail(String adminEmail);
}
