import java.util.Scanner;

public class PoundstoDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pounds=Double.parseDouble(scanner.nextLine());
        double courseOfDollar=1.31;

        double dollars=pounds*courseOfDollar;

        System.out.printf("%.3f",dollars);



    }
}
