import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        boolean isFound=false;
        for (int index = 0; index <= numbers.length - 1; index++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int indexLeft = 0; indexLeft <= index - 1; indexLeft++) {
                leftSum += numbers[indexLeft];
            }

            for (int indexRight = index + 1; indexRight <= numbers.length - 1; indexRight++) {
                rightSum += numbers[indexRight];
            }

            if(leftSum==rightSum){
                System.out.println(index);
                isFound=true;
            }

        }
        if(!isFound){
            System.out.println("no");
        }



    }
}
