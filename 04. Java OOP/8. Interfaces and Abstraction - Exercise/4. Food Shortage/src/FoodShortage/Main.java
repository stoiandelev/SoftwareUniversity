package FoodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Citizen> citizens = new HashMap<>();
        Map<String, Rebel> rebels = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            if (input.length == 3) {
                Rebel rebel = new Rebel(input[0], Integer.parseInt(input[1]), input[2]);
                rebels.put(input[0], rebel);
            } else if (input.length == 4) {
                Citizen citizen = new Citizen(input[0], Integer.parseInt(input[1]), input[2], input[3]);
                citizens.put(input[0], citizen);
            }
        }

        String buyer = scanner.nextLine();
        while (!buyer.equals("End")) {
            if (citizens.containsKey(buyer)) {
                Citizen current = citizens.get(buyer);
                current.buyFood();
            }
            if (rebels.containsKey(buyer)) {
                Rebel current = rebels.get(buyer);
                current.buyFood();
            }
            buyer = scanner.nextLine();
        }

        int food = 0;
        for (Citizen citizen : citizens.values()) {
            food += citizen.getFood();
        }
        for (Rebel rebel : rebels.values()) {
            food += rebel.getFood();

        }
        System.out.println(food);


    }


}

