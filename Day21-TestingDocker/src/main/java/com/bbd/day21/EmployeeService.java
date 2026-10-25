package com.bbd.day21;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EmployeeService {
    @Autowired EmployeeRepository repo;
    public List<Employee> getAll(){ return repo.findAll(); }
    public Employee getById(Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException("Not found "+id)); }
    public Employee create(Employee e){
        if(e.getSalary() < 0) throw new IllegalArgumentException("Salary must be >=0");
        return repo.save(e);
    }
    public double totalPayroll(){ return repo.findAll().stream().mapToDouble(Employee::getSalary).sum(); }
    public List<Employee> byRole(String role){ return repo.findByRole(role); }
}
