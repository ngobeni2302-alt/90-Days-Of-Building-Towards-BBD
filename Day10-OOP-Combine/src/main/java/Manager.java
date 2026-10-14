public class Manager extends Employee{
    private double managementBonus;

    public Manager(String name, String id, double baseSalary, double managementBonus){
        super(name, id, baseSalary);
        this.managementBonus = managementBonus;
    }

    public double getManagementBonus() {return managementBonus;}

    @Override
    public double calculateSalary() {return baseSalary + managementBonus;}

    @Override
    public String getRole() {return "Manager";}
}