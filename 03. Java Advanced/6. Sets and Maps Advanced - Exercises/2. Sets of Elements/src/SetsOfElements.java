import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int firstSetElement = Integer.parseInt(input[0]);
        int secondSetElement = Integer.parseInt(input[1]);

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetElement; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }

        for (int i = 0; i < secondSetElement; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }
        //Остава само дублираните елементи
        firstSet.retainAll(secondSet);

        for (Integer element : firstSet) {
            System.out.print(element + " ");
        }

    }
}
