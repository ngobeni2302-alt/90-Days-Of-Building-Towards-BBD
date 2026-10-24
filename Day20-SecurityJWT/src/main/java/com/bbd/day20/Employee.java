package com.bbd.day20;
import jakarta.persistence.*;
@Entity
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;
    private double salary;
    public Employee(){}
    public Employee(String n, String r, double s){ name=n; role=r; salary=s; }
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getName(){return name;} public void setName(String n){name=n;}
    public String getRole(){return role;} public void setRole(String r){role=r;}
    public double getSalary(){return salary;} public void setSalary(double s){salary=s;}
}
