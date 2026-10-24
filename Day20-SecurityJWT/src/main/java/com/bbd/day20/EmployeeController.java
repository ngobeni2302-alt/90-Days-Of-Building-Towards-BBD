package com.bbd.day20;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired private EmployeeRepository repo;

    @GetMapping public List<Employee> all(){ return repo.findAll(); }

    @PostMapping public Employee create(@RequestBody Employee e){ return repo.save(e); }

    @GetMapping("/{id}") public Employee byId(@PathVariable Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException("Not found")); }

    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ repo.deleteById(id); }
}
