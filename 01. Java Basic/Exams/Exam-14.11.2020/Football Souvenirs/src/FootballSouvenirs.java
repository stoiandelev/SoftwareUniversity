import java.util.Scanner;

public class FootballSouvenirs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String team=scanner.nextLine();
        String souvenir=scanner.nextLine();
        int countSouvenir=Integer.parseInt(scanner.nextLine());

        double price=0;
        double totalPrice=0;
        boolean validCountry=true;
        boolean validStock=true;


       switch (team) {
           case "Argentina":
               if (souvenir.equals("flags")) {
                   price = 3.25;
                   totalPrice = price * countSouvenir;
               } else if (souvenir.equals("caps")) {
                   price = 7.20;
                   totalPrice = price * countSouvenir;
               } else if (souvenir.equals("posters")) {
                   price = 5.10;
                   totalPrice = price * countSouvenir;
               } else if (souvenir.equals("stickers")) {
                   price = 1.25;
                   totalPrice = price * countSouvenir;
               } else {
                   System.out.println("Invalid stock!");
                   validStock=false;
               }
               break;
           case "Brazil":
               if (souvenir.equals("flags")) {
                   price = 4.20;
                   totalPrice = price * countSouvenir;
               } else if (souvenir.equals("caps")) {
                   price = 8.50;
                   totalPrice = price * countSouvenir;
               } else if (souvenir.equals("posters")) {
                   price = 5.35;
                   totalPrice = price * countSouvenir;
               } else if (souvenir.equals("stickers")) {
                   price = 1.20;
                   totalPrice = price * countSouvenir;
               } else {
                   System.out.println("Invalid stock!");
                   validStock=false;
               }
               break;
           case "Croatia":
               if (souvenir.equals("flags")) {
                   price = 2.75;
                   totalPrice = price * countSouvenir;
               } else if (souvenir.equals("caps")) {
                   price = 6.90;
                   totalPrice = price * countSouvenir;
               } else if (souvenir.equals("posters")) {
                   price = 4.95;
                   totalPrice = price * countSouvenir;
               } else if (souvenir.equals("stickers")) {
                   price = 1.10;
                   totalPrice = price * countSouvenir;
               } else {
                   System.out.println("Invalid stock!");
                   validStock=false;
               }
               break;
           case "Denmark":
               if (souvenir.equals("flags")) {
                   price = 3.10;
                   totalPrice = price * countSouvenir;
               } else if (souvenir.equals("caps")) {
                   price = 6.50;
                   totalPrice = price * countSouvenir;
               } else if (souvenir.equals("posters")) {
                   price = 4.80;
                   totalPrice = price * countSouvenir;
               } else if (souvenir.equals("stickers")) {
                   price = 0.90;
                   totalPrice = price * countSouvenir;
               } else {
                   System.out.println("Invalid stock!");
                   validStock=false;
               }
               break;
           default:
               System.out.println("Invalid country!");
               validCountry=false;

       }
        if(validCountry&&validStock){
            System.out.printf("Pepi bought %d %s of %s for %.2f lv.",countSouvenir,souvenir,team,totalPrice);
        }











    }
}
