import java.util.Scanner;

public class OscarsWeekInCinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name=scanner.nextLine();
        String hall=scanner.nextLine();
        int countTickets=Integer.parseInt(scanner.nextLine());

        double price=0;
        double totalPrice=0;


        switch (name){
            case "A Star Is Born":
                if(hall.equals("normal")){
                    price=7.50;
                    totalPrice=price*countTickets;
                }else if(hall.equals("luxury")){
                    price=10.50;
                    totalPrice=price*countTickets;
                }else if(hall.equals("ultra luxury")){
                    price=13.50;
                    totalPrice=price*countTickets;
                }break;
            case "Bohemian Rhapsody":
                if(hall.equals("normal")){
                    price=7.35;
                    totalPrice=price*countTickets;
                }else if(hall.equals("luxury")){
                    price=9.45;
                    totalPrice=price*countTickets;
                }else if(hall.equals("ultra luxury")){
                    price=12.75;
                    totalPrice=price*countTickets;
                }break;
            case "Green Book":
                if(hall.equals("normal")){
                    price=8.15;
                    totalPrice=price*countTickets;
                }else if(hall.equals("luxury")){
                    price=10.25;
                    totalPrice=price*countTickets;
                }else if(hall.equals("ultra luxury")){
                    price=13.25;
                    totalPrice=price*countTickets;
                }break;
            case "The Favourite":
                if(hall.equals("normal")){
                    price=8.75;
                    totalPrice=price*countTickets;
                }else if(hall.equals("luxury")){
                    price=11.55;
                    totalPrice=price*countTickets;
                }else if(hall.equals("ultra luxury")){
                    price=13.95;
                    totalPrice=price*countTickets;
                }break;

        }

        System.out.printf("%s -> %.2f lv.",name,totalPrice);
        

    }
}
