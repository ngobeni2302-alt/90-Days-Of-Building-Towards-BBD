import java.util.Scanner;

public class Main{
    public static double calculate(double firstNumber, char operator, double secondNumber){
        switch (operator){
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                if (secondNumber == 0){
                    throw new ArithmeticException("Cannot be divided by 0");
                }
                return firstNumber / secondNumber;
            default:
                throw new IllegalArgumentException("Invalid Operator: " + operator);
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter first number: ");
        double no1 = input.nextDouble();

        System.out.println("Enter Operator(+,-,*,/): ");
        char opera = input.next().charAt(0);

        System.out.println("Enter second number: ");
        double no2 = input.nextDouble();

        try {
            double results = calculate(no1, opera, no2);
            System.out.println("Results: " +no1+" "+ opera+" "+no2+" = "+results);

        }catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("Error: "+ e.getMessage());
        }
        input.close();
    }
}