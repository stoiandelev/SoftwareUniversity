import java.util.Arrays;
import java.util.Scanner;

public class Grupa2Task3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] items = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int entryPoint = Integer.parseInt(scanner.nextLine());
        int leftSum = 0;
        int rightSum = 0;
        String typeOfItemsToBreak = scanner.nextLine();
        int valueOfEntryPoint = items[entryPoint];

        if (typeOfItemsToBreak.equals("cheap")) {
            //leftSide
            for (int i = 0; i <= entryPoint - 1; i++) {
                if (items[i] < valueOfEntryPoint) {
                    leftSum += items[i];
                }
            }

            //rightSide
            for (int i = entryPoint + 1; i < items.length; i++) {
                if (items[i] < valueOfEntryPoint) {
                    rightSum += items[i];
                }
            }
        }else if (typeOfItemsToBreak.equals("expensive")){
            //leftSide
            for (int i = 0; i <= entryPoint - 1; i++) {
                if (items[i] >= valueOfEntryPoint) {
                    leftSum += items[i];
                }
            }

            //rightSide
            for (int i = entryPoint + 1; i < items.length; i++) {
                if (items[i] >= valueOfEntryPoint) {
                    rightSum += items[i];
                }
            }
        }

        if (leftSum>=rightSum){
            System.out.printf("Left - %d",leftSum);
        }else {
            System.out.printf("Right - %d",rightSum);
        }
    }
}
