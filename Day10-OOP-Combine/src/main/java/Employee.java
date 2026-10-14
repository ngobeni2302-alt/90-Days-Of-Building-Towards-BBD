public abstract class Employee{
    protected String name;
    protected String id;
    protected double baseSalary;

    public Employee(String name, String id, double baseSalary){
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public abstract String getRole();

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}
