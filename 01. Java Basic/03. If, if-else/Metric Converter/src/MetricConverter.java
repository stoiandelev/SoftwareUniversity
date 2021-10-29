import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input = Double.parseDouble(scanner.nextLine());
        String numberIn = scanner.nextLine();
        String numberOut = scanner.nextLine();

        double mm = 1000;
        double cm = 10;
        double result = 0.0;

        if (numberIn.equals("m")) {
            if (numberOut.equals("cm")) {
                result = input * 100;
                System.out.printf("%.3f",result);
            } else if (numberOut.equals("mm")) {
                result = input * mm;
                System.out.printf("%.3f",result);
            }

        }

        if (numberIn.equals("mm")) {
            if (numberOut.equals("m")) {
                result = input / mm;
                System.out.printf("%.3f",result);
            } else if (numberOut.equals("cm")) {
                result = input / cm;
                System.out.printf("%.3f",result);
            }
        }



        if (numberIn.equals("cm")) {
            if (numberOut.equals("m")) {
                result = input / 100;
                System.out.printf("%.3f",result);
            } else if (numberOut.equals("mm")) {
                result = input * cm;
                System.out.printf("%.3f",result);
            }
        }





    }

}