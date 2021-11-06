import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inventory = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .collect(Collectors.toList());

        String commands = scanner.nextLine();
        while (!commands.equals("Craft!")) {
            String token = commands.split(" - ")[0];
            String item = commands.split(" - ")[1];


            switch (token) {
                case "Collect":
                    if (inventory.contains(item)) {
                        break;
                    } else {
                        inventory.add(item);
                    }
                    break;
                case "Drop":
                    if (inventory.contains(item)) {
                        inventory.remove(item);
                    }
                    break;
                case "Combine Items":

                    String oldElement = item.split(":")[0];
                    String newElement = item.split(":")[1];

                    int index = inventory.indexOf(oldElement) + 1;
                    if(inventory.contains(oldElement)) {
                        inventory.add(index, newElement);
                       
                    }
                    break;
                case "Renew":
                    if(inventory.contains(item)){
                        int index1 = inventory.indexOf(item);
                        inventory.remove(item);
                        inventory.add(item);
                    break;
            }



        }
            commands = scanner.nextLine();


        }
        System.out.println(String.join(", ",inventory));


    }
}
