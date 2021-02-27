package com.employee.employee_management_system.controller;

import com.employee.employee_management_system.model.Employee;
import com.employee.employee_management_system.services.EmployeeService;
import com.employee.employee_management_system.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class EmployeeController {

    private final EmployeeService employeeService;
    private final SalaryService salaryService;

    @Autowired

    public EmployeeController(EmployeeService employeeService, SalaryService salaryService) {
        this.employeeService = employeeService;
        this.salaryService = salaryService;
    }

    @GetMapping("/employee-list")
    public String viewHomePage(Model model, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("admin") == null) {
            return "redirect:/";
        }

        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "frontPage";
    }

    @GetMapping(path = "/new-employee")
    public String displayEmployeeForm(Model model, HttpSession session, HttpServletRequest request){
        Object userObj = session.getAttribute("admin");
        if (userObj == null) return "redirect:/";

        model.addAttribute("invalid", session.getAttribute("invalid"));
        session.removeAttribute("invalid");
        model.addAttribute("employee", new Employee());
        return "employeeData";
    }

    @PostMapping("/new-employee")
    public String addEmployee(@ModelAttribute("employee") Employee employee, HttpSession session,Model model){

        Object userObj = session.getAttribute("admin");
        if (userObj == null) return "redirect:/";

        employeeService.createEmployee(employee);
        session.setAttribute("newemployee", employee);
        return "redirect:/employee-list";
    }

    @GetMapping("/update-employee/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model, HttpSession session){
        Object userObj = session.getAttribute("admin");
        if (userObj == null) return "redirect:/";

//        //set employee as a model attribute to pre-populate the form
        Employee employee = employeeService.findEmployee(id);
        model.addAttribute("employee", employee);
        return "updateEmployee";
    }

    @PostMapping("/update-employee/{id}")
    public String showEditEmployee(@ModelAttribute("employee") Employee employee, @PathVariable (value = "id") Long id, Model model, HttpSession session) {

        Object userObj = session.getAttribute("admin");
        if (userObj == null) return "redirect:/";

        //save employee to database
        employeeService.updateEmployee(employee, id);
        return "redirect:/employee-list";
    }

    @RequestMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id, Model model, HttpSession session) {
        Object userObj = session.getAttribute("admin");
        if (userObj == null) return "redirect:/";
        employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }

    @GetMapping("/employee-list/{id}")
    public String viewEmployee(@PathVariable(value="id") Long id, Model model, HttpSession session){
        Object userObj = session.getAttribute("admin");
        if (userObj == null) return "redirect:/";
        Employee employee = employeeService.findEmployee(id);

        model.addAttribute("employee", employee);
        model.addAttribute("salaries", salaryService.getEmployeeSalaries(id));
        return "employeeInfo";
    }

//    @GetMapping("/employee")
//    public String employeePage(Model model, HttpServletRequest request){
//        HttpSession session = request.getSession(false);
//        if (session == null || session.getAttribute("employee") == null) {
//            return "redirect:/";
//        }
//
//        model.addAttribute("employee", employeeService.getAllEmployees());
//        return "plainEmployeeInfo";
//    }

//    @GetMapping("/employee/{id}")
//    public String employee(@PathVariable(value="id") Long id, Model model, HttpSession session){
//        Object userObj = session.getAttribute("employee");
//        if (userObj == null) return "redirect:/";
//
//        Employee employee = employeeService.findEmployee(id);
//
//        model.addAttribute("employee", employee);
//        model.addAttribute("salaries", salaryService.getEmployeeSalaries(id));
//        return "plainEmployeeInfo";
//    }
}
