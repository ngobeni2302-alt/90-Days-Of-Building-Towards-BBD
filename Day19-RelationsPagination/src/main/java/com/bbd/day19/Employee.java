package com.bbd.day19;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank private String name;
    private String role;
    @Min(0) private double salary;

    // Many Employees -> One Department
    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;

    public Employee(){}
    public Employee(String name, String role, double salary){ this.name=name; this.role=role; this.salary=salary; }
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getName(){return name;} public void setName(String n){name=n;}
    public String getRole(){return role;} public void setRole(String r){role=r;}
    public double getSalary(){return salary;} public void setSalary(double s){salary=s;}
    public Department getDepartment(){return department;} public void setDepartment(Department d){department=d;}
}
