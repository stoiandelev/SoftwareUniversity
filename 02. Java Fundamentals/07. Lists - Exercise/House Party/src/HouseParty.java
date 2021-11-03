import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int command = Integer.parseInt(scanner.nextLine());

        List<String> namesList = new ArrayList<>();

        for (int i = 1; i <= command; i++) {
            String text = scanner.nextLine();
            String[] currentText = text.split("\\s+");

            if (currentText.length - 1. == 2) {
                String name = currentText[0];
                if (namesList.contains(name)) {
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    namesList.add(name);
                }


            } else {
                String name = currentText[0];
                if (namesList.contains(name)) {
                    namesList.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }


            }


        }

        printList(namesList);
    }

    private static void printList(List<String> namesList) {
        for (String name : namesList) {
            System.out.println(name);

        }
    }
}
