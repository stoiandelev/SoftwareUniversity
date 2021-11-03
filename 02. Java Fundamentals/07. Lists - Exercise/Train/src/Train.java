import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagon = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] currentInput = input.split("\\s+");

            if (currentInput[0].equals("Add")) {
                wagon.add(Integer.parseInt(currentInput[1]));
            } else {
                int passengerToAdd = Integer.parseInt(currentInput[0]);
                for (int index = 0; index < wagon.size(); index++) {
                    int passengerInWagon = wagon.get(index);
                    if (passengerToAdd + passengerInWagon <= maxCapacity) {
                        wagon.set(index, passengerToAdd + passengerInWagon);
                        break;

                    }

                }
            }

            input = scanner.nextLine();
        }
        printList(wagon);


    }

    private static void printList(List<Integer> wagon) {
        for (Integer i : wagon) {
            System.out.print(i +" ");
            
        }
    }


}
