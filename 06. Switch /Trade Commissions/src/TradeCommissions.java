import java.util.Scanner;

public class TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String city = scanner.nextLine();
        double sales = Double.parseDouble(scanner.nextLine());

        double commissions=0.0;
        boolean validCity=false;

        switch (city){
            case "Sofia":
                if (sales > 10000) {
                    commissions = 0.12;
                } else if (sales > 1000) {
                    commissions = 0.08;
                } else if (sales > 500) {
                    commissions = 0.07;
                } else if (sales >= 0) {
                    commissions = 0.05;
                }
                break;
            case "Varna":
                if (sales > 10000) {
                    commissions = 0.13;
                } else if (sales > 1000) {
                    commissions = 0.10;
                } else if (sales > 500) {
                    commissions = 0.075;
                } else if (sales     >= 0) {
                    commissions = 0.045;
                }
                break;
            case "Plovdiv":
                if (sales > 10000) {
                    commissions = 0.145;
                } else if (sales > 1000) {
                    commissions = 0.12;
                } else if (sales > 500) {
                    commissions = 0.08;
                } else if (sales >= 0) {
                    commissions = 0.055;
                }
                break;
            default:
                validCity = true;
                break;

        }
        double result=sales*commissions;

        if (!validCity && sales >= 0) {
            System.out.printf("%.2f", result);
        }
        else {
            System.out.println("error");
        }




    }
}

