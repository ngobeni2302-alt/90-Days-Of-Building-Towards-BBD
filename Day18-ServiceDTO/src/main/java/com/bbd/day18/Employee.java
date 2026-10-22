package com.bbd.day18;
import jakarta.persistence.*;
@Entity
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;
    private double salary;
    private String department;
    public Employee() {}
    public Employee(String name, String role, double salary, String department) {
        this.name=name; this.role=role; this.salary=salary; this.department=department;
    }
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getName(){return name;} public void setName(String n){name=n;}
    public String getRole(){return role;} public void setRole(String r){role=r;}
    public double getSalary(){return salary;} public void setSalary(double s){salary=s;}
    public String getDepartment(){return department;} public void setDepartment(String d){department=d;}
}
