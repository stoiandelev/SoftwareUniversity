import java.util.Scanner;

public class WorldSnookerChampionship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String etap=scanner.nextLine();
        String typeTicket=scanner.nextLine();
        int countTicket=Integer.parseInt(scanner.nextLine());
        String picture=scanner.nextLine();

        double price=0;
        double totalPrice=0;
        double totalPricePicture=0;



        switch (etap){
            case "Quarter final":
                if(typeTicket.equals("Standard")){
                    price=55.50;
                    totalPrice=price*countTicket;
                }else if(typeTicket.equals("Premium")){
                    price=105.20;
                    totalPrice=price*countTicket;
                }else if(typeTicket.equals("VIP")){
                    price=118.90;
                    totalPrice=price*countTicket;
                }break;
            case "Semi final":
                if(typeTicket.equals("Standard")){
                    price=75.88;
                    totalPrice=price*countTicket;
                }else if(typeTicket.equals("Premium")){
                    price=125.22;
                    totalPrice=price*countTicket;
                }else if(typeTicket.equals("VIP")){
                    price=300.40;
                    totalPrice=price*countTicket;
                }break;
            case "Final":
                if(typeTicket.equals("Standard")){
                    price=110.10;
                    totalPrice=price*countTicket;
                }else if(typeTicket.equals("Premium")){
                    price=160.66;
                    totalPrice=price*countTicket;
                }else if(typeTicket.equals("VIP")){
                    price=400;
                    totalPrice=price*countTicket;
                }break;

        }
        boolean freePicture = false;

        if (totalPrice > 4000) {
            totalPrice *= 0.75;
            freePicture = true;
        }
        else if (totalPrice > 2500){
            totalPrice *= 0.9;
        }
        if (picture.equals("Y") && !freePicture){
            totalPrice += 40 * countTicket;
        }





        System.out.printf("%.2f",totalPrice);







    }
}
