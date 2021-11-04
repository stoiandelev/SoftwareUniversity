import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a=Integer.parseInt(scanner.nextLine());
        String operator=scanner.nextLine();
        int b=Integer.parseInt(scanner.nextLine());

        switch (operator){
            case "/":
                isSumDivide(a,b);
                break;
            case "*":
                isSumMultiple(a,b);
                break;
            case "+":
                isSumAdd(a,b);
                break;
            case "-":
                isSumSubtraction(a,b);
                break;
        }
    }

    private static void isSumDivide(int a, int b) {
        int sum=0;
        sum=a/b;
        System.out.println(sum);

    }

    private static void isSumMultiple(int a, int b) {
        int sum=0;
        sum=a*b;
        System.out.println(sum);
    }

    private static void isSumAdd(int a, int b) {
        int sum=0;
        sum=a+b;
        System.out.println(sum);
    }

    private static void isSumSubtraction(int a, int b) {
        int sum=0;
        sum=a-b;
        System.out.println(sum);
    }
}
