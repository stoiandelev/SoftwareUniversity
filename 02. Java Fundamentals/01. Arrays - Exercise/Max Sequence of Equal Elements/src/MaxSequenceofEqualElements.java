import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceofEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        String[] inputAsArray = input.split(" ");

        int[] arrayAsIntegers = new int[inputAsArray.length];
        for (int i = 0; i < arrayAsIntegers.length; i++) {
            arrayAsIntegers[i] = Integer.parseInt(inputAsArray[i]);
        }


        int max = 0;
        int digit = 0;
        int counter = 0;

        for (int i = 1; i < arrayAsIntegers.length; i++) {


            if (arrayAsIntegers[i] == arrayAsIntegers[i - 1]) {
                counter++;
                if (counter > max) {
                    max = counter;
                    digit = arrayAsIntegers[i];
                }
            } else {
                counter = 0;
            }

        }

        if (max > 0) {
            for (int j = 0; j <= max; j++) {
                System.out.print(digit + " ");
            }
        }


    }


}










