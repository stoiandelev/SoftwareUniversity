import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MemoryGame_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String[] line = s.split("\\s+");

        ArrayList<String> list = new ArrayList<>(Arrays.asList(line));


        int moveCounter = 0;
        String input = scanner.nextLine();

        while (!input.equals("end") && !list.isEmpty()) {
            moveCounter++;
            String[] indices = input.split("\\s+");

            int firstIndex = Integer.parseInt(indices[0]);
            int secondIndex = Integer.parseInt(indices[1]);

            if ((firstIndex == secondIndex) ||
                    (firstIndex < 0 || firstIndex >= list.size()) ||
                    (secondIndex < 0 || secondIndex >= list.size())) {

                invalidInput(list, moveCounter);

            }else {
                String firstValue = list.get(firstIndex);
                String secondValue = list.get(secondIndex);

                if (firstValue.equals(secondValue)) {
                    System.out.printf("Congrats! You have found matching elements - %s!%n", list.get(firstIndex));
                    list.remove(firstValue);
                    list.remove(secondValue);

                } else {
                    System.out.println("Try again!");
                }
            }
            input = scanner.nextLine();
        }

        if (list.isEmpty()) {
            System.out.printf("You have won in %d turns!", moveCounter);
        } else {
            System.out.println("Sorry you lose :(");
            System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
        }

    }

    private static void invalidInput(ArrayList<String> list, int moveCounter) {
        String newElement = "-" + moveCounter + "a";

        list.add(list.size() / 2, newElement);
        list.add(list.size() / 2 + 1, newElement);

        System.out.println("Invalid input! Adding additional elements to the board");
    }


}