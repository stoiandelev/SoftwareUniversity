import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder cities = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equals("Travel")) {
            String[] splitted = command.split(":");
            String switchCommand = splitted[0];

            switch (switchCommand) {
                case "Add Stop":
                    int addStopIndex = Integer.parseInt(splitted[1]);
                    String newCity = splitted[2];

                    if (addStopIndex >= 0 && addStopIndex < cities.length()) {
                        cities.insert(addStopIndex, newCity);
                    }
                    System.out.println(cities);

                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(splitted[1]);
                    int endIndex = Integer.parseInt(splitted[2]);

                    if (startIndex >= 0 && startIndex < cities.length() && endIndex >= 0 && endIndex < cities.length()) {
                        cities.delete(startIndex, endIndex+1);
                    }
                    System.out.println(cities);
                    break;
                case "Switch":
                    String oldString = splitted[1];
                    String newString = splitted[2];

                    String destinationToString = cities.toString();
                    destinationToString = destinationToString.replace(oldString, newString);
                    cities = new StringBuilder(destinationToString);
                    System.out.println(cities);

                    break;


            }


            command = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", cities);
    }
}
