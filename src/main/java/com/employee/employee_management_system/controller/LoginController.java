package com.employee.employee_management_system.controller;

import com.employee.employee_management_system.model.Admin;
import com.employee.employee_management_system.model.Employee;
import com.employee.employee_management_system.services.AdminService;
import com.employee.employee_management_system.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final EmployeeService employeeService;
    private final AdminService adminService;

    @Autowired
    public LoginController(EmployeeService employeeService, AdminService adminService) {
        this.employeeService = employeeService;
        this.adminService = adminService;
    }

    @GetMapping("/")
    public String login(Model model){
        model.addAttribute("admin", new Admin());
        model.addAttribute("invalid", null);

        return "login";
    }

    @PostMapping("/")
    public String login(HttpSession session, Admin admin, Model model, Employee employee){
        Admin loggedInAdmin = adminService.getAdminByEmailAndPassword(admin.getEmail(), admin.getPassword());
        Employee thisEmployee = employeeService.getEmployeeByEmailAndPassword(employee.getEmail(), employee.getPassword());
        if (loggedInAdmin == null && thisEmployee == null) {
            //error message if email does not exist in database
            model.addAttribute("invalid", "Admin does not exist. Check login details or register.");
            return "login";
        }

        if(loggedInAdmin != null) {
            session.setAttribute("admin", loggedInAdmin);
            return "redirect:/employee-list";
        }else{
            session.setAttribute("employee", thisEmployee);
            model.addAttribute("employee", thisEmployee);
            model.addAttribute("salaries", thisEmployee.getEmployeeSalaryRecord());
            return "plainEmployeeInfo";
//            return "redirect:/employee";
        }
    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";  //Where you go after logout here.
    }
}
