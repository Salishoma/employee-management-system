package com.employee.employee_management_system.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class SalaryRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salaryId;
    private Double salary;
    @CreationTimestamp
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;
}