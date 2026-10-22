package com.bbd.day18;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

// Service layer = Business logic lives here, not in Controller - BBD rule
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<EmployeeDTO> getAll(String dept) {
        List<Employee> list = (dept != null) ? repository.findByDepartment(dept) : repository.findAll();
        return list.stream().map(EmployeeMapper::toDTO).collect(Collectors.toList());
    }

    public EmployeeDTO getById(Long id) {
        Employee emp = repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        return EmployeeMapper.toDTO(emp);
    }

    public EmployeeDTO create(EmployeeDTO dto) {
        // Business rule: Developers must be in Engineering dept
        if (dto.getRole().equalsIgnoreCase("Developer") && dto.getDepartment() == null) {
            dto.setDepartment("Engineering");
        }
        Employee saved = repository.save(EmployeeMapper.toEntity(dto));
        return EmployeeMapper.toDTO(saved);
    }

    public EmployeeDTO update(Long id, EmployeeDTO dto) {
        Employee existing = repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        existing.setName(dto.getName());
        existing.setRole(dto.getRole());
        existing.setSalary(dto.getSalary());
        existing.setDepartment(dto.getDepartment());
        return EmployeeMapper.toDTO(repository.save(existing));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) throw new EmployeeNotFoundException(id);
        repository.deleteById(id);
    }

    public double totalPayroll() {
        return repository.findAll().stream().mapToDouble(Employee::getSalary).sum();
    }
}
