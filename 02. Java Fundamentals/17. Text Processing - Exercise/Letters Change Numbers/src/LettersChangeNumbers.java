import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double totalSum = 0;


        String[] words = input.split("\\s+");

        for (String word : words) {
            double sumOfWord = getWordSum(word);
            totalSum += sumOfWord;

        }
        System.out.printf("%.2f",totalSum);


    }

    private static double getWordSum(String word) {
        //A12b
        double result = 0;
        char firstLetter = word.charAt(0);//A
        char secondLetter = word.charAt(word.length() - 1);//b
        double number = Double.parseDouble(word.substring(1, word.length() - 1));

        if (Character.isUpperCase(firstLetter)) {
            result = number / (firstLetter - 64);
            number = result;

        } else if (Character.isLowerCase(firstLetter)) {
            result = number * (firstLetter - 96);
            number = result;
        }

        if (Character.isUpperCase(secondLetter)) {
            result =number- (secondLetter - 64);
            number = result;
        } else if (Character.isLowerCase(secondLetter)) {
            result =number+ (secondLetter - 96);
        }

        return result;
    }

}
