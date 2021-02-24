package com.employee.employee_management_system.services;

import com.employee.employee_management_system.model.Admin;

public interface AdminService {
    Admin getAdminByEmailAndPassword(String email, String password);
}
