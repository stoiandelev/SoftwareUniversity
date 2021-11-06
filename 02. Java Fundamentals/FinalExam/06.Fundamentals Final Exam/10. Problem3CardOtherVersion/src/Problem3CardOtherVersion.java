import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem3CardOtherVersion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> cardsDeck = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(", ");
            String command = tokens[0];

            switch (command) {
                case "Add": // Add, {CardName}
                    String addCardName = tokens[1];
                    if (cardsDeck.contains(addCardName)) {
                        System.out.println("Card is already in the deck");
                    } else {
                        cardsDeck.add(addCardName);
                        System.out.println("Card successfully added");
                    }
                    break;

                case "Remove": // Remove, {CardName}
                    String removeCardName = tokens[1];
                    if (cardsDeck.contains(removeCardName)) {
                        cardsDeck.remove(removeCardName);
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Card not found");
                    }
                    break;

                case "Remove At": // Remove At, {index}
                    int indexRemove = Integer.parseInt(tokens[1]);

                    if (indexRemove >= 0 && indexRemove < cardsDeck.size()) {
                        cardsDeck.remove(indexRemove);
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;
                case "Insert": // Insert, {index}, {CardName}
                    int indexInsert = Integer.parseInt(tokens[1]);
                    String insertCardName = tokens[2];
                    if (indexInsert >= 0 && indexInsert < cardsDeck.size()) {
                        if (cardsDeck.contains(insertCardName)) {
                            System.out.println("Card is already added");
                        } else {
                            cardsDeck.add(indexInsert, insertCardName);
                            System.out.println("Card successfully added");
                        }
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;
            }
        }
        System.out.println(String.join(", ", cardsDeck));

    }
}