package com.bbd.springboot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Spring Data JPA automatically provides save(), findAll(), findById(), and deleteById() out of the box!
}