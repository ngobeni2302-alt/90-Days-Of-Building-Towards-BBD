package com.bbd.day22;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {
    @Autowired EmployeeRepository repo;
    @GetMapping public List<Employee> all(){ return repo.findAll(); }
    @GetMapping("/{id}") public ResponseEntity<Employee> byId(@PathVariable Long id){
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public ResponseEntity<Employee> create(@Valid @RequestBody Employee e){
        return new ResponseEntity<>(repo.save(e), HttpStatus.CREATED);
    }
    @PutMapping("/{id}") public ResponseEntity<Employee> update(@PathVariable Long id, @Valid @RequestBody Employee upd){
        return repo.findById(id).map(ex->{
            ex.setName(upd.getName()); ex.setRole(upd.getRole()); ex.setSalary(upd.getSalary()); ex.setDepartment(upd.getDepartment());
            return ResponseEntity.ok(repo.save(ex));
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){
        if(!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id); return ResponseEntity.noContent().build();
    }
    @GetMapping("/payroll") public Map<String,Double> payroll(){
        double total = repo.findAll().stream().mapToDouble(Employee::getSalary).sum();
        return Map.of("totalPayroll", total);
    }
    @GetMapping("/stats") public Map<String,Object> stats(){
        List<Employee> all = repo.findAll();
        return Map.of(
            "count", all.size(),
            "totalPayroll", all.stream().mapToDouble(Employee::getSalary).sum(),
            "avgSalary", all.stream().mapToDouble(Employee::getSalary).average().orElse(0),
            "departments", all.stream().map(Employee::getDepartment).distinct().toList()
        );
    }
}
