import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] splitCommand = command.split("\\s+");

            if (splitCommand[0].equals("Delete")) {
                int deleteElement = Integer.parseInt(splitCommand[1]);
                numbers.removeAll(Arrays.asList(deleteElement));

            } else {
                int element = Integer.parseInt(splitCommand[1]);
                int index = Integer.parseInt(splitCommand[2]);
                numbers.add(index, element);

            }

            command = scanner.nextLine();
        }

        printList(numbers);


    }

    private static void printList(List<Integer> numbers) {
        for (Integer number : numbers) {
            System.out.print(number + " ");

        }
    }
}
