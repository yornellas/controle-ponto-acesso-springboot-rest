package com.github.yornellas.controlepontoacesso.entities;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class User {

    @Id
    private Long id;

    private String name;

    @ManyToOne
    private UserCategory userCathegory;

    @ManyToOne
    private Company company;

    @ManyToOne
    private AccessLevel accessLevel;

    @ManyToOne
    private WorkHours workHours;

    private BigDecimal tolerance;
    private LocalDateTime beginWorkHours;
    private LocalDateTime endWorkHours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserCategory getUserCathegory() {
        return userCathegory;
    }

    public void setUserCathegory(UserCategory userCategory) {
        this.userCathegory = userCategory;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public WorkHours getWorkHours() {
        return workHours;
    }

    public void setWorkHours(WorkHours workHours) {
        this.workHours = workHours;
    }

    public BigDecimal getTolerance() {
        return tolerance;
    }

    public void setTolerance(BigDecimal tolerance) {
        this.tolerance = tolerance;
    }

    public LocalDateTime getBeginWorkHours() {
        return beginWorkHours;
    }

    public void setBeginWorkHours(LocalDateTime beginWorkHours) {
        this.beginWorkHours = beginWorkHours;
    }

    public LocalDateTime getEndWorkHours() {
        return endWorkHours;
    }

    public void setEndWorkHours(LocalDateTime endWorkHours) {
        this.endWorkHours = endWorkHours;
    }
}
