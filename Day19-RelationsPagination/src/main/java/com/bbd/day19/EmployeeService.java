package com.bbd.day19;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired EmployeeRepository empRepo;
    @Autowired DepartmentRepository deptRepo;

    public Department createDepartment(String name){
        return deptRepo.save(new Department(name));
    }

    public Employee addEmployeeToDept(Long deptId, Employee emp){
        Department dept = deptRepo.findById(deptId).orElseThrow(() -> new RuntimeException("Dept not found"));
        emp.setDepartment(dept);
        return empRepo.save(emp);
    }

    public Page<Employee> getEmployeesByDept(String deptName, Pageable pageable){
        return empRepo.findByDepartmentName(deptName, pageable);
    }

    public Page<Employee> getAllPaginated(Pageable pageable){
        return empRepo.findAll(pageable);
    }
}
