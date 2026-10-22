package com.bbd.day18;
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id){ super("Employee not found: "+id); }
}
