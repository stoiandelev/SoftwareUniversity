package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Birthable> dataId = new ArrayList<>();
        String line = scanner.nextLine();

        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");

            switch (tokens[0]) {
                case "Citizen":
                    dataId.add(new Citizen(tokens[1], Integer.parseInt(tokens[2]),
                            tokens[3], tokens[4]));
                    break;
                case "Robot":
                    String id = tokens[1];
                    String model = tokens[2];
                    break;
                case "Pet":
                    dataId.add(new Pet(tokens[1], tokens[2]));
                    break;

            }

            line = scanner.nextLine();
        }

        String specificYear = scanner.nextLine();


        for (Birthable date : dataId) {
            if (date.getBirthDate().endsWith(specificYear)) {
                System.out.println(date.getBirthDate());
            }
        }


    }
}
