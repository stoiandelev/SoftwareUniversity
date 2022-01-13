import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] colors = scanner.nextLine().split("\\s+");
        int changeCounter = Integer.parseInt(scanner.nextLine());

        List<Lights> lightsList = new ArrayList<>();

        for (String color : colors) {
            Lights lights = new Lights(Color.valueOf(color));
            lightsList.add(lights);
        }

        for (int i = 0; i < changeCounter; i++) {
            lightsList.forEach(lights -> {
                //сменям цвета
                //печатам
                lights.changeColor();
                System.out.print(lights.getColor() + " ");
            });
            System.out.println();
        }


    }
}
