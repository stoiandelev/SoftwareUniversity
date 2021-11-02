import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e->Integer.parseInt(e)).toArray();

        int oddSum=0;
        int evenSum=0;

        for (int number : numbers) {
            if(number%2==0){
                evenSum+=number;
            }else{
                oddSum+=number;
            }
        }

        int different=evenSum-oddSum;
        System.out.println(different);
        
    }
}
