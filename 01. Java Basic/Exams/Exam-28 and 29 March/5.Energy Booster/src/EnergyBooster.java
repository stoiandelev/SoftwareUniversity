import java.util.Scanner;

public class EnergyBooster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String size = scanner.nextLine();
        int num = Integer.parseInt(scanner.nextLine());
        double prize = 0;
        double totalPrize = 0;


        switch (fruit) {
            case "Watermelon":
                if (size.equals("big")) {
                    prize = 5 * 28.70;
                    totalPrize = num * prize;
                } else {
                    prize = 2 * 56;
                    totalPrize = num * prize;
                } break;
            case "Mango":
                if (size.equals("big")) {
                    prize = 5 * 19.60;
                    totalPrize = num * prize;
                } else {
                    prize = 2 * 36.66;
                    totalPrize = num * prize;
                }break;

            case "Pineapple":
                if (size.equals("big")) {
                    prize = 5 * 24.80;
                    totalPrize = num * prize;
                } else {
                    prize = 2 * 42.10;
                    totalPrize = num * prize;
                }break;
            case "Raspberry":
                if (size.equals("big")) {
                    prize = 5 * 15.20;
                    totalPrize = num * prize;
                } else {
                    prize = 2 * 20;
                    totalPrize = num * prize;
                }break;

        }

        if(totalPrize>=400&&totalPrize<=1000){
            totalPrize=totalPrize-(totalPrize*0.15);
        }else if(totalPrize>1000){
            totalPrize=totalPrize/2;

        }
        System.out.printf("%.2f lv.",totalPrize);

















    }

}

