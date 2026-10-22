package com.bbd.day18;
import jakarta.validation.constraints.*;

// DTO = Data Transfer Object - what client sends/receives, not Entity
public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "Name required")
    @Size(min=2, max=100)
    private String name;

    @NotBlank(message = "Role required")
    private String role;

    @Min(0) private double salary;
    
    private String department;

    // Extra field only in DTO, not in Entity - calculated
    private String salaryGrade;

    public EmployeeDTO() {}
    public EmployeeDTO(Long id, String name, String role, double salary, String dept, String grade) {
        this.id=id; this.name=name; this.role=role; this.salary=salary; this.department=dept; this.salaryGrade=grade;
    }
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getName(){return name;} public void setName(String n){name=n;}
    public String getRole(){return role;} public void setRole(String r){role=r;}
    public double getSalary(){return salary;} public void setSalary(double s){salary=s;}
    public String getDepartment(){return department;} public void setDepartment(String d){department=d;}
    public String getSalaryGrade(){return salaryGrade;} public void setSalaryGrade(String g){salaryGrade=g;}
}
