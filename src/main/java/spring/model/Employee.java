package spring.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Employee extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "job_level")
    private String jobLevel;

    @Column(name = "seniority")
    private float seniority;

    @Column(name = "position")
    private String position;

    @Column(name = "employee_code")
    private String employeeCode;
}
