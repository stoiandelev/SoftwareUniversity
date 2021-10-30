import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String leapYear=scanner.nextLine();
        int holidaysInYear=Integer.parseInt(scanner.nextLine());
        int weekendToBornCity=Integer.parseInt(scanner.nextLine());


        double weekendSofia = (48 - weekendToBornCity) * (3.0 / 4.0);
        double holidaysPlay = holidaysInYear * (2.0 / 3.0);
        double playDays = weekendSofia + holidaysPlay + weekendToBornCity;

        if ("leap".equals(leapYear)) {
             playDays= playDays * 1.15;
        }
        System.out.printf("%.0f", Math.floor(playDays));









    }
}
