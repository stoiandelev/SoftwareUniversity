import java.util.Scanner;

public class RadianaToCelsius {

        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);

            double rad=Double.parseDouble(scanner.nextLine());
            double deg=180 / Math.PI * rad;
            System.out.print((int)Math.floor(deg));


        }
    }

