package com.example.laboratorio4.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="departments")
public class Departments {

    @Id
    @Column(name = "department_id")
    private int id;

    @Column(name = "department_name")
    @NotBlank
    @Size(max = 30, message = "el nombre no puede tener más de 30 caracteres")
    private String departmentname;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employees managerid;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Locations locationid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public Employees getManagerid() {
        return managerid;
    }

    public void setManagerid(Employees managerid) {
        this.managerid = managerid;
    }

    public Locations getLocationid() {
        return locationid;
    }

    public void setLocationid(Locations locationid) {
        this.locationid = locationid;
    }
}
