import java.util.Scanner;

public class CelsiusToFahrenheint {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Celsius=");
        Double celsius= scanner.nextDouble();
        Double fahrenheint=celsius*1.8+32;
        System.out.print("Fahrenheit=");
        System.out.printf("%.2f",fahrenheint);

    }
    }





