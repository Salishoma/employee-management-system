package com.employee.employee_management_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Getter
@Setter

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<SalaryRecord> employeeSalaryRecord;

    public Employee() {
        System.out.println("Empty employee constructor created");
    }
}
