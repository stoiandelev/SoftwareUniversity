import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" +");
        List<String> gifts = new ArrayList<>();
        Collections.addAll(gifts, input);

        String command = sc.nextLine();
        while (!command.equals("No Money")) {
            String[] tokens = command.split(" +");
            switch (tokens[0]) {
                case "OutOfStock":
                    while (gifts.contains(tokens[1])) {
                        gifts.set(gifts.indexOf(tokens[1]), "None");
                    }
                    break;
                case "Required":
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < gifts.size()) {
                        gifts.set(index, tokens[1]);
                    }
                    break;
                case "JustInCase":
                    if (gifts.size() > 0) {
                        gifts.set(gifts.size() - 1, tokens[1]);
                    }
                    break;
            }
            command = sc.nextLine();
        }

        for (String string : gifts) {
            if (!string.equals("None")) {
                System.out.print(string + " ");
            }
        }
    }
}