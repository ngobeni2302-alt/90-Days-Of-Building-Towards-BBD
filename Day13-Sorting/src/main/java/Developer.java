public class Developer extends Employee{
    private double codingBonus;

    public Developer(String name, String id, double baseSalary, double codingBonus){
        super(name, id, baseSalary);
        this.codingBonus = codingBonus;
    }

    public double getCodingBonus() {return codingBonus;}

    @Override
    public double calculateSalary() {return baseSalary + this.codingBonus;}

    @Override
    public String getRole() {return "Developer";}
}
