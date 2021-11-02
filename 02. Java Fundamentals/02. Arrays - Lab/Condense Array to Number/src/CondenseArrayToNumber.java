import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] number= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        while (number.length>1){
            int[] condensed=new int[number.length-1];

            for (int i = 0; i <condensed.length; i++) {
                condensed[i] = number[i] + number[i + 1];
            }
            number=condensed;
        }
        System.out.println(number[0]);



    }
}
