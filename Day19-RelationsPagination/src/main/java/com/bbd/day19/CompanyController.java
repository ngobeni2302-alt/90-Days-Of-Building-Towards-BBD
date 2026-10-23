package com.bbd.day19;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CompanyController {
    @Autowired EmployeeService service;
    @Autowired DepartmentRepository deptRepo;

    @PostMapping("/departments")
    public Department createDept(@RequestBody Department dept){ return deptRepo.save(dept); }

    @GetMapping("/departments")
    public java.util.List<Department> allDepts(){ return deptRepo.findAll(); }

    @PostMapping("/departments/{deptId}/employees")
    public Employee addEmp(@PathVariable Long deptId, @RequestBody Employee emp){
        return service.addEmployeeToDept(deptId, emp);
    }

    // Pagination: ?page=0&size=2&sort=salary,desc
    @GetMapping("/employees")
    public Page<Employee> getAllPaginated(@PageableDefault(size=5) Pageable pageable){
        return service.getAllPaginated(pageable);
    }

    @GetMapping("/employees/department/{deptName}")
    public Page<Employee> byDept(@PathVariable String deptName, Pageable pageable){
        return service.getEmployeesByDept(deptName, pageable);
    }
}
