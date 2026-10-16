import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Company {

    private Map<String, Employee> employeeMap;
    private List<Employee> employeeList;

    public Company() {
        this.employeeMap = new HashMap<>();
        this.employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee e) throws DuplicateIdException {
        if (e == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        if (employeeMap.containsKey(e.getId())) {
            throw new IllegalArgumentException("Duplicate employee ID: " + e.getId());
        }
        employeeMap.put(e.getId(), e);
        employeeList.add(e);
    }

    public Employee findById(String id) {
        Employee e = employeeMap.get(id);
        if (e == null) {
            throw new EmployeeNotFoundException("Employee ID not found: " + id);
        }
        return e;
    }

    public List<Employee> findByRole(String role) {
        List<Employee> filtered = new ArrayList<>();
        for (Employee e : employeeList) {
            if (e.getRole().equalsIgnoreCase(role)) {
                filtered.add(e);
            }
        }
        return filtered;
    }

    public double totalPayroll() {
        double total = 0;
        for (Employee e : employeeList) {
            total += e.calculateSalary();
        }
        return total;
    }

    public boolean removeEmployee(String id) {
        Employee removed = employeeMap.remove(id);
        if (removed != null) {
            employeeList.remove(removed);
            return true;
        }
        return false;
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employeeList);
    }
}