import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCompounds = Integer.parseInt(scanner.nextLine());

        TreeSet<String> elements = new TreeSet<>();

        for (int i = 0; i < countCompounds; i++) {
            String chemicalCompounds = scanner.nextLine();
            String[] chemicalElements = chemicalCompounds.split("\\s+");

            //начин 1
            //elements.addAll(Arrays.asList(chemicalElements));

            //начин 2
            Collections.addAll(elements, chemicalElements);
        }

        elements.forEach(el -> System.out.print(el + " "));
    }
}
