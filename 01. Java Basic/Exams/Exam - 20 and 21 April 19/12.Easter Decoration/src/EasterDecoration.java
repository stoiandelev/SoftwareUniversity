import java.util.Scanner;

public class EasterDecoration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int customers=Integer.parseInt(scanner.nextLine());

        int countItem=0;
        double price=0;
        double sumItem=0;
        int countFinish=0;
        double realTotalSum=0;


        for (int i = 1; i <=customers; i++) {

            String purchase=scanner.nextLine();

            while(!purchase.equals("Finish")){
                String currentPurchase=purchase;

                switch (currentPurchase){
                    case "basket":
                        price=1.50;
                        sumItem+=price;
                        countItem++;
                        break;
                    case "wreath":
                        price=3.80;
                        sumItem+=price;
                        countItem++;
                        break;
                    case "chocolate bunny":
                        price=7;
                        sumItem+=price;
                        countItem++;
                        break;

                }




                purchase=scanner.nextLine();

            }
            if(countItem%2==0){
                sumItem=sumItem*0.80;
            }
            System.out.printf("You purchased %d items for %.2f leva.%n",countItem,sumItem);
            countFinish++;
            realTotalSum+=sumItem;


            countItem=0;
            price=0;
            sumItem=0;

        }
        double averageSum=realTotalSum/countFinish;
            System.out.printf("Average bill per client is: %.2f leva.",averageSum);















    }
}
