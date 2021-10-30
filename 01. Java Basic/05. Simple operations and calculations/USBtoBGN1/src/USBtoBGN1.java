import java.util.Scanner;

public class USBtoBGN1 {

        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);

            System.out.print("Dollar=");
            double dollar=Double.parseDouble(scanner.nextLine());
            double bgn=1.79549*dollar;
            System.out.print("BGN=");
            System.out.printf("%.2f",bgn);
            System.out.print(" BGN");


        }
    }


