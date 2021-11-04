import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        List<People> peoples = new ArrayList<>();

        while (!text.equals("End")) {

            String name = text.split("\\s+")[0];
            String id = text.split("\\s+")[1];
            int year = Integer.parseInt(text.split("\\s+")[2]);

            People people = new People(name, id, year);
            peoples.add(people);


            text = scanner.nextLine();

        }
        peoples.sort(Comparator.comparing(People::getYear));

        for (People people : peoples) {
            System.out.println(people);

        }
    }
}
