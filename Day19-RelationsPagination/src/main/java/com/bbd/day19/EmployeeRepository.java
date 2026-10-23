package com.bbd.day19;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findByDepartmentName(String deptName, Pageable pageable);
}
