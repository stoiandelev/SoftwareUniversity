import java.util.Scanner;

public class TravelAgency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String city = scanner.nextLine();
        String packageType = scanner.nextLine();    //("noEquipment",  "withEquipment", "noBreakfast" или "withBreakfast")
        String vipDiscount = scanner.nextLine(); //"yes" или "no"
        int days = Integer.parseInt(scanner.nextLine());
        double price = 0.0;
        

        if (days < 1) {
            System.out.println("Days must be positive number!");
            return;

        }

        if (days > 7) {
            days = days - 1;    //1 day free
        }

        switch (city) {
            case "Bansko":
            case "Borovets":
                if (packageType.equals("withEquipment")) {
                    price = days * 100.00;
                    if (vipDiscount.equals("yes")) {
                        price = price - (price * 0.10);
                    }
                } else if (packageType.equals("noEquipment")) {
                    price = days * 80.00;
                    if (vipDiscount.equals("yes")) {
                        price = price - (price * 0.05);
                    }
                } else {
                    System.out.println("Invalid input!");
                }

                break;

            case "Varna":
            case "Burgas":
                if (packageType.equals("withBreakfast")) {
                    price = days * 130.00;
                    if (vipDiscount.equals("yes")) {
                        price = price - (price * 0.12);
                    }
                } else if (packageType.equals("noBreakfast")) {
                    price = days * 100.00;
                    if (vipDiscount.equals("yes")) {
                        price = price - (price * 0.07);
                    }
                } else {
                    System.out.println("Invalid input!");
                }

                break;

            default:
                System.out.println("Invalid input!");
        }

        if (price > 0) {    //it won't change if we hit Invalid input
            System.out.printf("The price is %.2flv! Have a nice time!", price);
        }

    }
}









