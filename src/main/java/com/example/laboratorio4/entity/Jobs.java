package com.example.laboratorio4.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "jobs")
public class Jobs {

    @Id
    @Column(name = "job_id")
    private String jobid;
    @Column(name = "job_title",nullable = false)
    @NotBlank
    @Size(max=40)
    private String jobtitle;
    @Digits(integer = 6, fraction = 0)
    @Positive
    @Column(name = "min_salary")
    private int minsalary;
    @Column(name = "max_salary")
    @Digits(integer = 6, fraction = 0)
    @Positive
    private int maxsalary;

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public int getMinsalary() {
        return minsalary;
    }

    public void setMinsalary(int minsalary) {
        this.minsalary = minsalary;
    }

    public int getMaxsalary() {
        return maxsalary;
    }

    public void setMaxsalary(int maxsalary) {
        this.maxsalary = maxsalary;
    }
}
