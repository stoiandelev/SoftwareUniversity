import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lengthCake = Integer.parseInt(scanner.nextLine());
        int wightCake = Integer.parseInt(scanner.nextLine());

        int sumCake = lengthCake * wightCake;


        String input = scanner.nextLine();

        while (!input.equals("STOP")) {
            int currentCake = Integer.parseInt(input);
            sumCake -= currentCake;
            if (sumCake < 0) {
                System.out.printf("No more cake left! You need %d pieces more.", Math.abs(sumCake));
                break;
            }
            input=scanner.nextLine();
        }


        if (input.equals("STOP")) {
            System.out.printf("%d pieces are left.", sumCake);
        }





    }
}
