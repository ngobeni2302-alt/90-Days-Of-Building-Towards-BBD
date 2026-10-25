package com.bbd.day21;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired EmployeeService service;
    @GetMapping public List<Employee> all(){ return service.getAll(); }
    @GetMapping("/{id}") public Employee byId(@PathVariable Long id){ return service.getById(id); }
    @PostMapping public ResponseEntity<Employee> create(@RequestBody Employee e){ return new ResponseEntity<>(service.create(e), HttpStatus.CREATED); }
    @GetMapping("/payroll") public double payroll(){ return service.totalPayroll(); }
}
