package com.employee.employee_management_system.controller;


import com.employee.employee_management_system.model.Employee;
import com.employee.employee_management_system.model.SalaryRecord;
import com.employee.employee_management_system.repository.EmployeeRepository;
import com.employee.employee_management_system.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class SalaryController {

    private final SalaryService salaryService;
    private final EmployeeRepository employeeRepository;

    @Autowired

    public SalaryController(SalaryService salaryService, EmployeeRepository employeeRepository) {
        this.salaryService = salaryService;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employee-list/{id}/payment")
    public String paymentForm(@PathVariable("id") Long id, Model model, HttpSession session){
        Employee employee = employeeRepository.findById(id).get();
        model.addAttribute("invalid", session.getAttribute("invalid"));
        model.addAttribute("userId", id);
        session.removeAttribute("invalid");
        model.addAttribute("employee", employee);
        model.addAttribute("salaries", new SalaryRecord());
        model.addAttribute("standardDate", new Date());
        return "paymentForm";
    }

    @PostMapping("/employee-list/{id}/payment")
    public String makePayment(@PathVariable("id") long id, @ModelAttribute("salaries") SalaryRecord salaryRecord, HttpSession session){
        salaryService.paySalary(id, salaryRecord);
//        model.addAttribute("salaries", salaryRecord);
//        session.setAttribute("employee", employee);
        session.setAttribute("salaries", salaryRecord);
        return "redirect:/employee-list/{id}";
    }
}
