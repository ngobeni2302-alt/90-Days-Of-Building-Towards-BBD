package com.bbd.day19;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Department {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // One Department -> Many Employees
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Employee> employees = new ArrayList<>();

    public Department(){}
    public Department(String name){ this.name=name; }
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getName(){return name;} public void setName(String n){name=n;}
    public List<Employee> getEmployees(){return employees;}
    public void addEmployee(Employee e){ employees.add(e); e.setDepartment(this); }
}
