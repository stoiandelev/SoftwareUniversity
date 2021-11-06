import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("END")) {

            String switchCommand = command.split(" ")[0];

            switch (switchCommand) {
                case "Change":
                    String paintingNumber = command.split(" ")[1];
                    String changeNumber = command.split(" ")[2];

                    if (numbers.contains(paintingNumber)) {
                        int indexPaintingNumber = numbers.indexOf(paintingNumber);
                        numbers.set(indexPaintingNumber, changeNumber);
                    }

                    break;
                case "Hide":
                    String hideNumber = command.split(" ")[1];
                    if (numbers.contains(hideNumber)) {
                        numbers.remove(hideNumber);
                    }

                    break;
                case "Switch":
                    String switchNumber1 = command.split(" ")[1];
                    String switchNumber2 = command.split(" ")[2];

                    if (numbers.contains(switchNumber1) && numbers.contains(switchNumber2)) {
                        int index1 = numbers.indexOf(switchNumber1);
                        int index2 = numbers.indexOf(switchNumber2);
                        numbers.set(index1, switchNumber2);
                        numbers.set(index2, switchNumber1);

                    }


                    break;
                case "Insert":
                    int place =Integer.parseInt(command.split(" ")[1]);
                    String paintingNumber1 = command.split(" ")[2];



                    if (place < 0 || place > numbers.size() - 1) {
                        break;
                    } else {
                        numbers.add(place+1, paintingNumber1);
                    }


                    break;
                case "Reverse":
                    Collections.reverse(numbers);
                    break;

            }


            command = scanner.nextLine();
        }
        System.out.print(numbers.toString().replaceAll("[\\[\\],]", ""));



    }
}
