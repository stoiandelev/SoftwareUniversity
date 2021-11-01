import java.util.Scanner;

public class PaintingEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String size=scanner.nextLine();
        String color=scanner.nextLine();
        int batch=Integer.parseInt(scanner.nextLine());

        int price=0;

        switch (size){
            case "Large":
                if(color.equals("Red")){
                    price=16;
                }else if(color.equals("Green")){
                    price=12;
                }else if(color.equals("Yellow")){
                    price=9;
                }
                break;
            case "Medium":
                if(color.equals("Red")){
                    price=13;
                }else if(color.equals("Green")){
                    price=9;
                }else if(color.equals("Yellow")){
                    price=7;
                }
                break;
            case "Small":
                if(color.equals("Red")){
                    price=9;
                }else if(color.equals("Green")){
                    price=8;
                }else if(color.equals("Yellow")){
                    price=5;
                }
                break;

        }
        double totalPrice=batch*price;
        double cost=totalPrice*0.35;

        double sum=totalPrice-cost;

        System.out.printf("%.2f leva.",sum);




















    }
}
