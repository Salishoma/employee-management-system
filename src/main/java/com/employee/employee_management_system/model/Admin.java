package com.employee.employee_management_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Admin {

    @Id
    private long id;
    private String email;
    private String password;
}
