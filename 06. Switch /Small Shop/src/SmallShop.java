import java.util.Scanner;

public class SmallShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        String city = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        if (product.equals("coffee")) {
            if (city.equals("Varna")) {
                System.out.println(quantity * 0.45);
            } else if (city.equals("Sofia")) {
                System.out.println(quantity * 0.50);
            } else {
                System.out.println(quantity * 0.40);
            }
        }

        if (product.equals("water")) {
            if (city.equals("Varna")) {
                System.out.println(quantity * 0.70);
            } else if (city.equals("Sofia")) {
                System.out.println(quantity * 0.80);
            } else {
                System.out.println(quantity * 0.70);
            }
        }

        if (product.equals("beer")) {
            if (city.equals("Varna")) {
                System.out.println(quantity * 1.10);
            } else if (city.equals("Sofia")) {
                System.out.println(quantity * 1.20);
            } else {
                System.out.println(quantity * 1.15);
            }
        }

        if (product.equals("sweets")) {
            if (city.equals("Varna")) {
                System.out.println(quantity * 1.35);
            } else if (city.equals("Sofia")) {
                System.out.println(quantity * 1.45);
            } else {
                System.out.println(quantity * 1.30);
            }
        }

        if (product.equals("peanuts")) {
            if (city.equals("Varna")) {
                System.out.println(quantity * 1.55);
            } else if (city.equals("Sofia")) {
                System.out.println(quantity * 1.60);
            } else {
                System.out.println(quantity * 1.50);
            }
        }


    }
}
