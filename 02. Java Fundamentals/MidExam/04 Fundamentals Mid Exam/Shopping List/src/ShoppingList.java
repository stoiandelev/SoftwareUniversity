import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> groceries = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("Go Shopping!")) {
            String firstItem = command.split(" ")[0];
            String secondItem = command.split(" ")[1];

            switch (firstItem) {

                case "Urgent":
                    if (groceries.contains(secondItem)) {
                        break;
                    } else {
                        groceries.add(0, secondItem);
                    }
                    break;
                case "Unnecessary":
                    if (groceries.contains(secondItem)) {
                        groceries.remove(secondItem);

                    } else {
                        break;
                    }
                    break;
                case "Correct":
                    String newItem = command.split(" ")[2];
                    int index = groceries.indexOf(secondItem);

                    if (groceries.contains(secondItem)) {
                        groceries.add(index, newItem);
                        groceries.remove(secondItem);
                    }

                    break;
                case "Rearrange":
                    if (groceries.contains(secondItem)) {
                        int index1 = groceries.indexOf(secondItem);
                        groceries.remove(secondItem);
                        groceries.add(secondItem);
                    }
                    break;


            }


            command = scanner.nextLine();
        }
        System.out.println(String.join(", ", groceries));


    }
}
