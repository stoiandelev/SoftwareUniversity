import java.util.Scanner;

public class EasterTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destination=scanner.nextLine();
        String date=scanner.nextLine();
        int night=Integer.parseInt(scanner.nextLine());

        double price=0;


        switch (date){
            case "21-23":
                if(destination.equals("France")){
                    price=night*30;
                }else if(destination.equals("Italy")){
                    price=night*28;
                }else if(destination.equals("Germany")) {
                    price =night*32;
                }
                break;
            case "24-27":
                if(destination.equals("France")){
                    price=night*35;
                }else if(destination.equals("Italy")){
                    price=night*32;
                }else if(destination.equals("Germany")) {
                    price =night*37;
                }
                break;
            case "28-31":
                if(destination.equals("France")){
                    price=night*40;
                }else if(destination.equals("Italy")){
                    price=night*39;
                }else if(destination.equals("Germany")) {
                    price = night*43;
                }
                break;


        }

        System.out.printf("Easter trip to %s : %.2f leva.",destination,price);



    }
}
