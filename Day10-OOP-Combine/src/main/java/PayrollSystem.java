import java.util.List;
import java.util.ArrayList;

public class PayrollSystem {
    private List<Employee> employees;

    public PayrollSystem(){this.employees = new ArrayList<>();}

    public void addEmployee(Employee employee){
        if (employee == null){
            throw new IllegalArgumentException("Error: Employee Not Valid");
        }
        this.employees.add(employee);
    }

    public double getTotalPayroll(){
        double sum = 0;
        for (Employee em : employees){
            double sala = em.calculateSalary();
            sum += sala;
        }
        return sum;
    }

    public Employee findEmployee(String id){
        for (Employee ec1 : employees){
            if (ec1.getId().equals(id)){
                return ec1;
            }
        }
        return null;
    }

    public List<Employee> getEmployees() {return new ArrayList<>(employees);}
}
