import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    int number = Integer.parseInt(tokens[1]);
                    numbers.add(number);
                    break;
                case "Insert":
                    int insertNumber = Integer.parseInt(tokens[1]);
                    int insertIndex = Integer.parseInt(tokens[2]);
                    if(isValidIndex(insertIndex,numbers.size())){
                        numbers.add(insertIndex, insertNumber);
                    }else{
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int removeNumber = Integer.parseInt(tokens[1]);
                    if (isValidIndex(removeNumber,numbers.size())) {
                        numbers.remove(removeNumber);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    String direction = tokens[1];
                    int count = Integer.parseInt(tokens[2]);

                    if (direction.equals("right")) {
                        for (int i = 0; i < count; i++) {
                            int lastNumber = numbers.get(numbers.size() - 1);
                            numbers.remove(numbers.size() - 1);
                            numbers.add(0, lastNumber);
                        }

                    } else {
                        for (int i = 0; i < count; i++) {
                            int firstNumber = numbers.get(0);
                            numbers.remove(0);
                            numbers.add(firstNumber);

                        }


                    }
                    break;
            }
            input = scanner.nextLine();
        }

        printList(numbers);


    }

    private static boolean isValidIndex(int index ,int length) {
        return index>=0 && index<=length-1;
    }

    private static void printList(List<Integer> numbers) {
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
