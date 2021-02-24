package com.employee.employee_management_system.controller;

import com.employee.employee_management_system.model.Employee;
import com.employee.employee_management_system.model.SalaryRecord;
import com.employee.employee_management_system.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee-list")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "frontPage";
    }

    @GetMapping(path = "/new-employee")
    public String displayEmployeeForm(Model model, HttpSession session){
        model.addAttribute("invalid", session.getAttribute("invalid"));
        session.removeAttribute("invalid");
        model.addAttribute("employee", new Employee());
        return "employeeData";
    }

    @PostMapping("/new-employee")
    public String addEmployee(@ModelAttribute("employee") Employee employee, HttpSession session,Model model){

//        Employee employee1 = (Employee) model.getAttribute("employee");
        employeeService.createEmployee(employee);
        session.setAttribute("newemployee", employee);
        return "redirect:/employee-list";
    }


    @GetMapping("/update-employee/{id}")
    public String showEditEmployee(@PathVariable (value = "id") Long id, Model model) {
        model.addAttribute("employee", employeeService.findEmployee(id));
        return "updateEmployee";
    }

    @RequestMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id, Model model) {

        employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }

//    @GetMapping("/{id}")
//    public String viewEmployee(@PathVariable(value="id") Long id, Model model){
//        Employee employee = employeeService.findEmployee(id);
//        List<SalaryRecord> salaryHistory = employeeService.getEmployeeSalaryHistory(employee);
//        model.addAttribute("employee", employee);
//        return "employeeInfo";
//    }
}
