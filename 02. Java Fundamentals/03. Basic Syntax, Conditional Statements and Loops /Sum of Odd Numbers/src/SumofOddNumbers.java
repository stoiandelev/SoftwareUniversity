import java.util.Scanner;

public class SumofOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        int sum=0;
        int currentOdd=1;

        for (int i = 0; i <n ; i++) {
            System.out.println(currentOdd);
            sum+=currentOdd;
            currentOdd=currentOdd+2;


        }
        System.out.printf("Sum: %d",sum);
    }
}
