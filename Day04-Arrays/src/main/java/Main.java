public class Main {

    public static int findMax(int[] array){
        if (array == null || array.length == 0){
            throw new IllegalArgumentException("Error: Array List Not Valid");
        }

        int max = array[0];

        for (int i = 1; i < array.length; i++){
            if(array[i] > max) {
                max = array[i];
            }
        }return max;
    }

    public static int findMin(int[] array){
        if (array == null || array.length == 0){
            throw new IllegalArgumentException("Error: Array List Not Valid");
        }

        int min = array[0];

        for (int i = 1; i < array.length; i++){
            if (array[i] < min){
                min = array[i];
            }
        }return min;
    }

    public static int calculateSum(int[] array){
        if (array == null || array.length == 0){
            throw new IllegalArgumentException("Error: Array List Not Valid");
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++){
            sum += i;
        }return sum;
    }
}