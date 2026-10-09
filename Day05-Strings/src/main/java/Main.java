public class Main {
    private static void nullInput(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Error: String cannot be null");
        }
    }

    public static String reverseString(String str){
        String newStr = "";

        nullInput(str);

        for (int i = str.length() - 1; i >= 0; i--){
            newStr += str.charAt(i);
        }return newStr;
    }

    public static Boolean isPalindrome(String str){
        nullInput(str);

        String newStr = str.toLowerCase();
        return newStr.equals(reverseString(newStr));
    }

    public static int countVowels(String str){
        nullInput(str);

        int count = 0;
        String newStr = str.toLowerCase();

        for (int i = 0; i < newStr.length(); i++){
            char c = newStr.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }return count;
    }

    public static int countWords(String str){
        nullInput(str);

        String newStr = str.trim().toLowerCase();

        if (newStr.isEmpty()){
            return 0;
        }

        String[] words = newStr.split("\\s+");
        return words.length;

    }
}