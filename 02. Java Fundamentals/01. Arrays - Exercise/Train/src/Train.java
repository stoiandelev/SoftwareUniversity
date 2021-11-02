import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        for (int index = 0; index < n; index++) {
            int number = Integer.parseInt(scanner.nextLine());
            System.out.print(number+ " ");
            sum+=number;


        }
        System.out.println();
        System.out.println(sum);
    }
}
