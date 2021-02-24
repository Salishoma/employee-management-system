package com.employee.employee_management_system.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditModel implements Serializable {

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "emp_date", nullable = false, updatable = false)
//    @CreatedDate
//    private Date empDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "arrived_at", nullable = false)
//    @CreatedDate
//    private LocalDate arrivedAt;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "departed_at", nullable = false)
//    @CreatedDate
//    private LocalDate departedAt;
//
//    public Date getEmpDate() {
//        return empDate;
//    }
//
//    public void setEmpDate(Date empDate) {
//        this.empDate = empDate;
//    }
//
//    public LocalDate getArrivedAt() {
//        return arrivedAt;
//    }
//
//    public void setArrivedAt(LocalDate arrivedAt) {
//        this.arrivedAt = arrivedAt;
//    }
//
//    public LocalDate getDepartedAt() {
//        return departedAt;
//    }
//
//    public void setDepartedAt(LocalDate departedAt) {
//        this.departedAt = departedAt;
//    }
}
