import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {

            String car = input.split(", ")[1];

            if (input.contains("IN")) {
                parkingLot.add(car);
            } else {
                parkingLot.remove(car);
            }

            input = scanner.nextLine();
        }
        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String element : parkingLot) {
                System.out.println(element);
            }

        }
    }
}
