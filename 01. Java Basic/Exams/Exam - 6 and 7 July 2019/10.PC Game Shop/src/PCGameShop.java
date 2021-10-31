import java.util.Scanner;

public class PCGameShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalGamesSold = Integer.parseInt(scanner.nextLine());

        int hearthstoneCounter = 0;
        int fortniteCounter = 0;
        int overWatchCounter = 0;
        int othersCounter = 0;


        for (int i = 1; i <= totalGamesSold; i++) {
           String gameName = scanner.nextLine();
            switch (gameName) {

                case "Hearthstone":
                    hearthstoneCounter++;
                    break;
                case "Fornite":
                    fortniteCounter++;
                    break;
                case "Overwatch":
                    overWatchCounter++;
                    break;
                default:
                    othersCounter++;

            }

        }

        double hearthstonePercent = 1.0 * hearthstoneCounter / totalGamesSold * 100;
        double fortnitePercent = 1.0 * fortniteCounter / totalGamesSold * 100;  //
        double overwatchPercent = 1.0 * overWatchCounter / totalGamesSold * 100;
        double othersPercent = 1.0 * othersCounter / totalGamesSold * 100;

        System.out.printf("Hearthstone - %.2f%%%n", hearthstonePercent);
        System.out.printf("Fornite - %.2f%%%n", fortnitePercent);
        System.out.printf("Overwatch - %.2f%%%n", overwatchPercent);
        System.out.printf("Others - %.2f%%%n", othersPercent);




        }


    }

