package com.bbd.day17;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    public List<Employee> getAll(@RequestParam(required = false) String role) {
        if (role != null) return repository.findByRole(role);
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PostMapping
    public ResponseEntity<Employee> create(@Valid @RequestBody Employee employee) {
        Employee saved = repository.save(employee);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @Valid @RequestBody Employee updated) {
        Employee existing = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        existing.setName(updated.getName());
        existing.setRole(updated.getRole());
        existing.setSalary(updated.getSalary());
        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) throw new EmployeeNotFoundException(id);
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/payroll")
    public Map<String, Double> totalPayroll() {
        double total = repository.findAll().stream()
                .mapToDouble(Employee::getSalary).sum();
        return Map.of("totalPayroll", total);
    }
}
