package com.employee.employee_management_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class SalaryRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salaryId;
    private Double salary;
    private Date date;
    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;
}