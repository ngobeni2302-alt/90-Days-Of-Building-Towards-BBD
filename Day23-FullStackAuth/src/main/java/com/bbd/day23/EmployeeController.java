package com.bbd.day23;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController @RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired EmployeeRepository repo;
    @GetMapping public List<Employee> all(){ return repo.findAll(); }
    @PostMapping public ResponseEntity<Employee> create(@RequestBody Employee e){ return new ResponseEntity<>(repo.save(e), HttpStatus.CREATED); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){ repo.deleteById(id); return ResponseEntity.noContent().build(); }
    @GetMapping("/stats") public Map<String,Object> stats(){
        List<Employee> all = repo.findAll();
        return Map.of("count", all.size(), "totalPayroll", all.stream().mapToDouble(Employee::getSalary).sum(), "avgSalary", all.stream().mapToDouble(Employee::getSalary).average().orElse(0));
    }
}
