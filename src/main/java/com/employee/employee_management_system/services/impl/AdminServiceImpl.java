package com.employee.employee_management_system.services.impl;

import com.employee.employee_management_system.model.Admin;
import com.employee.employee_management_system.repository.AdminRepository;
import com.employee.employee_management_system.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin getAdminByEmailAndPassword(String email, String password) {
        Optional<Admin> admin = adminRepository.findByEmailAndPassword(email, password);
        return admin.orElse(null);

    }
}
