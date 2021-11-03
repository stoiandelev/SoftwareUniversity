import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            if (command.equals("Contains")) {
                int number = Integer.parseInt(tokens[1]);
                checkIfContainsNumber(numbers, number);
            } else if (command.equals("Print")) {
                String secondCommand = tokens[1];
                if (secondCommand.equals("even")) {
                    printAllEvenNumbers(numbers);
                } else if (secondCommand.equals("odd")) {
                    printAllOddNumbers(numbers);
                }
            }  else if (command.equals("Get")) {
                printAllNumSum(numbers);
            } else if (command.equals("Filter")) {
                String condition = tokens[1];
                int number = Integer.parseInt(tokens[2]);
                switch (condition) {
                    case "<":
                        printSmallerThanNum(numbers, number);
                        break;
                    case ">":
                        printBiggerThanNum(numbers, number);
                        break;
                    case ">=":
                        printBiggerAndEqualThanNum(numbers, number);
                        break;
                    case "<=":
                        printSmallerAndEqualThaNnum(numbers, number);
                        break;
                }
            }


            input = scanner.nextLine();
        }
    }

    private static void checkIfContainsNumber(List<Integer> numbers, int number) {
        boolean numberFound = false;
        for (int index = 0; index < numbers.size(); index++) {
            if (numbers.get(index).equals(number)) {
                numberFound = true;
                break;
            }
        }
        if (numberFound) {
            System.out.println("Yes");
        } else {
            System.out.println("No such number");
        }
    }

    private static void printAllEvenNumbers(List<Integer> numbers) {
        for (int index = 0; index < numbers.size(); index++) {
            if (numbers.get(index) % 2 == 0) {
                System.out.print(numbers.get(index) + " ");
            }
        }
        System.out.println();
    }

    private static void printAllOddNumbers(List<Integer> numbers) {
        for (int index = 0; index < numbers.size(); index++) {
            if (numbers.get(index) % 2 == 1) {
                System.out.print(numbers.get(index) + " ");
            }
        }
        System.out.println();
    }

    private static void printAllNumSum(List<Integer> numbers) {
        int sum = 0;
        for (int index = 0; index < numbers.size(); index++) {
            sum = sum + numbers.get(index);
        }
        System.out.println(sum);
    }

    private static void printSmallerThanNum(List<Integer> numbers, int number) {
        for (int index = 0; index < numbers.size(); index++) {
            if (numbers.get(index) < number) {
                System.out.print(numbers.get(index) + " ");
            }
        }
        System.out.println();
    }

    private static void printBiggerThanNum(List<Integer> numbers, int number) {
        for (int index = 0; index < numbers.size(); index++) {
            if (numbers.get(index) > number) {
                System.out.print(numbers.get(index) + " ");
            }
        }
        System.out.println();
    }

    private static void printBiggerAndEqualThanNum(List<Integer> numbers, int number) {
        for (int index = 0; index < numbers.size(); index++) {
            if (numbers.get(index) >= number) {
                System.out.print(numbers.get(index) + " ");
            }
        }
        System.out.println();
    }

    private static void printSmallerAndEqualThaNnum(List<Integer> numbers, int number) {
        for (int index = 0; index < numbers.size(); index++) {
            if (numbers.get(index) <= number) {
                System.out.print(numbers.get(index) + " ");
            }
        }
        System.out.println();
    }
}