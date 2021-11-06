import java.util.*;
import java.util.stream.Collectors;

public class ListTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> cardDeck = Arrays.stream(scan.nextLine().split("\\:"))
                .collect(Collectors.toList());

        String input = scan.nextLine();
        List<String> newDeck = new ArrayList<>();

        while (!input.equals("Ready")) {
            String[] tokens = input.split("\\s+");

            String command = tokens[0];

            switch (command) {
                case "Add":
                    String cardName = tokens[1];
                    if(cardDeck.contains(cardName)){
                        int indexOfCard = cardDeck.indexOf(cardName);
                        String card = cardDeck.get(indexOfCard);
                        newDeck.add(card);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Insert":
                    String cardName1 = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    if(index < 0 || index > cardDeck.size() - 1){
                        System.out.println("Error!");
                        break;
                    }
                    if(cardDeck.contains(cardName1)){
                        newDeck.add(index, cardName1);
                    } else {
                        System.out.println("Error!");
                    }
                    break;
                case "Remove":
                    String cardName2 = tokens[1];
                    if(newDeck.contains(cardName2)){
                        newDeck.remove(cardName2);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Swap":
                    String card1 = tokens[1];
                    String card2 = tokens[2];
                    int index1 = newDeck.indexOf(card1);
                    int index2 = newDeck.indexOf(card2);
                    newDeck.set(index1, card2);
                    newDeck.set(index2, card1);
                    break;
                case "Shuffle":
                    Collections.reverse(newDeck);


                    break;

            }
            input = scan.nextLine();
        }

        System.out.print(newDeck.toString().replaceAll("[\\[\\],]", ""));

    }
}