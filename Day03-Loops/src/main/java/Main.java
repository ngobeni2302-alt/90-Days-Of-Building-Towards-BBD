public class Main{
    public static String[] generateTable(int number){
        String[] table = new String[10];

        if (number <=0){
            throw new IllegalArgumentException("Error: Number must be greater than 0");
        }

        for (int i = 1; i <= 10; i++){
            int results = number * i;
            table[i - 1] = number + " x "+i+" = " + results;
        }return table;
    }

    public static int calculateSum(int number){
        int sum = 0;

        if (number <= 0){
            throw new IllegalArgumentException("Error: Number must be greater than 0");
        }

        for (int i = 1; i <= number; i++){
            sum += i;
        }return sum;
    }
}