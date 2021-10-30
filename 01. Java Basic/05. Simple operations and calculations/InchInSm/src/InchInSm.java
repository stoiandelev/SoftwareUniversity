import java.util.Scanner;

public class InchInSm {

        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);

            System.out.print("Inches=");
            Double inches=scanner.nextDouble();
            Double centimeters = inches * 2.54;
            System.out.print("Centimeters = ");
            System.out.println(centimeters);


        }
    }


