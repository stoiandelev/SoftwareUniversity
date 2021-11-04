import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1=Integer.parseInt(scanner.nextLine());
        int number2=Integer.parseInt(scanner.nextLine());
        int number3=Integer.parseInt(scanner.nextLine());

        int sumOfFirstTwo=intSumOfFirstThoInteger(number1,number2);
        int sumSubtractThirdInteger=sumSubtractThirdIntegerAndSum(sumOfFirstTwo,number3);
        System.out.println(sumSubtractThirdInteger);


    }

    private static int intSumOfFirstThoInteger(int number1, int number2) {
        int sum=0;
        sum=number1+number2;
        return sum;
    }

    private static int sumSubtractThirdIntegerAndSum(int sumOfFirstTwo, int number3) {
        int sumSubtractThirdInteger=0;
        sumSubtractThirdInteger=sumOfFirstTwo-number3;
        return sumSubtractThirdInteger;
    }


}
