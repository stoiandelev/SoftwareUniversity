import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(e -> Integer.parseInt(e)).toArray();
        String input = scanner.nextLine();
        int counter = 0;

        while (!input.equals("End")) {
            int index = Integer.parseInt(input);
            if (index >= numbers.length) {
                input = scanner.nextLine();
                continue;
            }

            if(numbers[index] == -1){
                input = scanner.nextLine();
                continue;

            }
            int current = numbers[index];
            numbers[index] = -1;
            counter++;
            for (int i = 0; i < numbers.length; i++) {

                if(numbers[i] > current && numbers[i] != -1){
                    numbers[i] -= current;
                }
                else if (numbers[i]<= current && numbers[i] != -1){
                    numbers[i] += current;
                }
            }


            input = scanner.nextLine();
        }

        System.out.printf("Shot targets: %d -> ", counter);
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}