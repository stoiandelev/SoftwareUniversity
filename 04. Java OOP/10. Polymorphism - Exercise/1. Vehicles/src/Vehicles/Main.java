package Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.ToDoubleBiFunction;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();

        String[] cars = scanner.nextLine().split("\\s+");
        vehicleMap.put("Car", new Car(Double.parseDouble(cars[1]), Double.parseDouble(cars[2])));

        String[] trucks = scanner.nextLine().split("\\s+");
        vehicleMap.put("Truck", new Truck(Double.parseDouble(trucks[1]), Double.parseDouble(trucks[2])));

        int commandsCount = Integer.parseInt(scanner.nextLine());

        while (commandsCount-- > 0) {
            String command = scanner.nextLine();

            String[] params = command.split("\\s+");

            double arguments = Double.parseDouble(params[2]);


            if (command.contains("Drive")) {
                System.out.println(vehicleMap.get(params[1]).drive(arguments));
            } else {
                vehicleMap.get(params[1]).refuel(arguments);

            }
        }
        for (Vehicle vehicle : vehicleMap.values()) {
            System.out.println(vehicle.toString());
        }
    }
}
