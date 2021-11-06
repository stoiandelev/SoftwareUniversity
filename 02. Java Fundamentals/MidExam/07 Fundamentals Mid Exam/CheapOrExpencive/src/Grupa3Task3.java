import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Grupa3Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int entryIndex = Integer.parseInt(scanner.nextLine());
        String elementType = scanner.nextLine();

        int leftSum = 0;
        int rightSum = 0;

        for (int i = entryIndex - 1; i >= 0; i--) {
            if (elementType.equals("cheap")) {
                if (numbers[i] < numbers[entryIndex]) {
                    leftSum += numbers[i];
                }
            } else if (elementType.equals("expensive")) {
                if (numbers[i] >= numbers[entryIndex]) {
                    leftSum += numbers[i];
                }
            }
        }
        for (int i = entryIndex + 1; i < numbers.length; i++) {
            if (elementType.equals("cheap")) {
                if (numbers[i] < numbers[entryIndex]) {
                    rightSum += numbers[i];
                }
            } else if (elementType.equals("expensive")) {
                if (numbers[i] >= numbers[entryIndex]) {
                    rightSum += numbers[i];
                }
            }
        }
        if (leftSum == rightSum) {
            System.out.printf("Left - %d", leftSum);
        } else if (leftSum > rightSum) {
            System.out.printf("Left - %d", leftSum);
        } else {
            System.out.printf("Right - %d", rightSum);
        }
    }
}