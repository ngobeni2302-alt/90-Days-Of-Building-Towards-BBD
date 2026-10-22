package com.bbd.day18;

// Mapper converts Entity <-> DTO - BBD standard pattern
public class EmployeeMapper {
    
    public static EmployeeDTO toDTO(Employee emp) {
        String grade = "C";
        if (emp.getSalary() > 50000) grade = "A";
        else if (emp.getSalary() > 30000) grade = "B";
        
        return new EmployeeDTO(
            emp.getId(),
            emp.getName(),
            emp.getRole(),
            emp.getSalary(),
            emp.getDepartment(),
            grade
        );
    }

    public static Employee toEntity(EmployeeDTO dto) {
        Employee emp = new Employee();
        emp.setId(dto.getId());
        emp.setName(dto.getName());
        emp.setRole(dto.getRole());
        emp.setSalary(dto.getSalary());
        emp.setDepartment(dto.getDepartment());
        return emp;
    }
}
