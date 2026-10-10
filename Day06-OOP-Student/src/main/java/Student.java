public class Student {
    private String name;
    private int age;
    private double marks;

    public Student(String name, int age, double marks){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be invalid");
        }
        this.name = name;

        if (age < 16 || age > 100){
            throw new IllegalArgumentException("Age cannot be lower than 16 or greater than 100");
        }
        this.age = age;

        if (marks < 0 || marks > 100 ){
            throw new IllegalArgumentException("Marks can not be lower than 0 or greater than 100");
        }
        this.marks = marks;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMarks() {
        return marks;
    }

    public char getGrade(){
        if (this.marks >= 80 && this.marks <= 100){
            return 'A';
        } else if (this.marks >= 70) {
            return 'B';
        } else if (this.marks >= 60 ) {
            return 'C';
        } else if (this.marks >= 50) {
            return 'D';
        }else {
            return 'F';
        }

    }

    public boolean isPass(){
        return this.marks >= 50;
    }
}