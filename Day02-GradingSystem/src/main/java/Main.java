import java.util.Scanner;

public class Main{
    public static String getGrade(int mark){
        if (mark > 100 || mark < 0){
            throw new IllegalArgumentException("Error: Invalid mark! Must be 0-100");
        }

        if (mark >= 80){
            return "A";
        } else if (mark >= 60){
            return "B";
        } else if (mark >= 50) {
            return "C";
        } else{
            return "F";
        }
    }

    public static String getMessage(String grade){
        switch (grade){
            case "A":
                return "Excellent! - BBD level";
            case "B":
                return "Good job!";
            case "C":
                return "Pass - keep cooking";
            case "F":
                return "Fail - try again";
            default:
                throw new IllegalArgumentException("Error: Invalid mark! Must be 0-100");
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your mark(0-100): ");
        int mark = scanner.nextInt();

        try {
            String grade = getGrade(mark);
            String message = getMessage(grade);
            System.out.println("Mark: " + mark + " -> Grade: " + grade + " - " + message);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}