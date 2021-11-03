import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = 255;

        int numberOflines = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < numberOflines; i++) {
            int pourLiters = Integer.parseInt(scanner.nextLine());
            capacity -= pourLiters;

            if (capacity < 0) {
                System.out.println("Insufficient capacity!");
                capacity += pourLiters;
            }

        }
        System.out.println(255 - capacity);


    }
}
