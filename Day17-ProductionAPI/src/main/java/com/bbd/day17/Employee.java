package com.bbd.day17;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 2, max = 100, message = "Name must be 2-100 chars")
    private String name;

    @NotBlank(message = "Role cannot be empty")
    private String role;

    @Min(value = 0, message = "Salary must be >= 0")
    @Max(value = 1000000, message = "Salary too high")
    private double salary;

    public Employee() {}

    public Employee(String name, String role, double salary) {
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}
