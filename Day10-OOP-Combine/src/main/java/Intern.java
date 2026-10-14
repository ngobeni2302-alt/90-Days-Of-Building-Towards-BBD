public class Intern extends Employee{

    public Intern(String name, String id, double baseSalary){
        super(name, id, baseSalary);
    }

    @Override
    public double calculateSalary() {return baseSalary;}

    @Override
    public String getRole() {return "Intern";}
}