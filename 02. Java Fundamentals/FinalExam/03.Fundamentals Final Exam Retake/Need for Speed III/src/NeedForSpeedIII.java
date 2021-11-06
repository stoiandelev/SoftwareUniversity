import java.util.*;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberCars = Integer.parseInt(scanner.nextLine());

        Map<String, List<Integer>> listCar = new TreeMap<>();

        for (int i = 0; i < numberCars; i++) {
            String[] currentCarData = scanner.nextLine().split("\\|");
            String car = currentCarData[0];
            int mileage = Integer.parseInt(currentCarData[1]);
            int fuel = Integer.parseInt(currentCarData[2]);

            List<Integer> current = new LinkedList<>();
            current.add(mileage);
            current.add(fuel);
            listCar.put(car, current);
        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")) {
            String[] commandSplit = command.split(" : ");
            String firsPositionCommandSplit = commandSplit[0];
            String car = commandSplit[1];
            switch (firsPositionCommandSplit) {
                case "Drive":

                    int distance = Integer.parseInt(commandSplit[2]);
                    int fuel = Integer.parseInt(commandSplit[3]);

                    List<Integer> dataCar = listCar.get(car);
                    int distanceReal = dataCar.get(0);
                    int fuelReal = dataCar.get(1);

                    if (fuelReal < fuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        distanceReal += distance;
                        fuelReal -= fuel;
                        listCar.get(car).set(0, distanceReal);
                        listCar.get(car).set(1, fuelReal);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
                        if (distanceReal > 100000) {
                            System.out.println(String.format("Time to sell the %s!", car));
                            listCar.remove(car);
                            break;
                        }
                    }
                    break;
                case "Refuel":
                    int fuelRefuel = Integer.parseInt(commandSplit[2]);
                    int fuelRealTheMoment = listCar.get(car).get(1);
                    fuelRealTheMoment += fuelRefuel;
                    if (fuelRealTheMoment >= 75) {
                        fuelRefuel = (fuelRealTheMoment - 75) - fuelRefuel;
                        fuelRealTheMoment = 75;
                    }
                    listCar.get(car).set(1, fuelRealTheMoment);
                    System.out.println(String.format("%s refueled with %d liters", car, Math.abs(fuelRefuel)));

                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(commandSplit[2]);
                    int realDistance = listCar.get(car).get(0);

                    int revertDistance = realDistance - kilometers;
                    if (revertDistance < 10000) {
                        revertDistance = 10000;
                    } else {
                        System.out.println(String.format("%s mileage decreased by %d kilometers", car, kilometers));
                    }
                    listCar.get(car).set(0, revertDistance);

                    break;


            }


            command = scanner.nextLine();
        }
        listCar
                .entrySet()
                .stream()
                .sorted((l, r) -> r.getValue().get(0) - l.getValue().get(0))
                .forEach(e -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", e.getKey(), e.getValue().get(0), e.getValue().get(1)));

    }
}
