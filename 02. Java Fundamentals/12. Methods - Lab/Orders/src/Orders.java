import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product=scanner.nextLine();
        int quantity=Integer.parseInt(scanner.nextLine());

        totalPriceForAll(product,quantity);
    }

    private static void totalPriceForAll(String product, int quantity) {
        if(product.equals("coffee")){
            double price=1.50;
            double sum=price*quantity;
            System.out.printf("%.2f",sum);
        }else if(product.equals("water")){
            double price=1.00;
            double sum=price*quantity;
            System.out.printf("%.2f",sum);
        }else if(product.equals("coke")){
            double price=1.40;
            double sum=price*quantity;
            System.out.printf("%.2f",sum);
        }else if(product.equals("snacks")){
            double price=2.00;
            double sum=price*quantity;
            System.out.printf("%.2f",sum);
        }

    }
}
