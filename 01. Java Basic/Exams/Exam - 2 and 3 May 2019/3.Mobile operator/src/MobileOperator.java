
import java.util.Scanner;

public class MobileOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String time=scanner.nextLine();
        String type=scanner.nextLine();
        String internet=scanner.nextLine();
        int numMonth=Integer.parseInt(scanner.nextLine());

        double price=0;


        switch (type){
            case "Small":
                if(time.equals("one")){
                price=9.98;
                }else {
                    price=8.58;
                }
                break;
            case "Middle":
                if(time.equals("one")){
                    price=18.99;
                }else {
                    price=17.09;
                }
                break;
            case "Large":
                if(time.equals("one")){
                    price=25.98;
                }else {
                    price=23.59;
                }
                break;
            case "ExtraLarge":
                if(time.equals("one")){
                    price=35.99;
                }else {
                    price=31.79;
                }
                break;

        }

        if(internet.equals("yes")){
            if(price<=10){
                price+=5.50;
            }else if(price<=30){
                price+=4.35;
            }else if(price>30){
                price+=3.85;
            }
        }

        if(time.equals("two")){
            price=price*0.9625;
        }
        double totalSum=price*numMonth;

        System.out.printf("%.2f lv.",totalSum);




















    }
}
