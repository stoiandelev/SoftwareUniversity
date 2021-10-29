import java.util.Scanner;


public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double dubai = Double.parseDouble(scanner.nextLine());
        int puzzle = Integer.parseInt(scanner.nextLine());
        int talkingDolls = Integer.parseInt(scanner.nextLine());
        int teddyBears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int tracks = Integer.parseInt(scanner.nextLine());

        double totalPuzzle = puzzle * 2.60;
        double totalTalkingDolls = talkingDolls * 3;
        double totalTeddyBears = teddyBears * 4.10;
        double totalMinions = minions * 8.20;
        double totalTracks = tracks * 2;

        int totalOrder = puzzle + talkingDolls + teddyBears + minions + tracks;
        double totalSale = totalPuzzle + totalTalkingDolls + totalTeddyBears + totalMinions + totalTracks;

        double discount = 0;
        if (totalOrder >= 50) {
            discount = totalSale / 4.0;

            double priceWithDiscount = totalSale - discount;
            double rent = priceWithDiscount * 0.10;
            double ebitda = priceWithDiscount - rent;
            if (dubai <= ebitda) {
                double haveMoney=ebitda-dubai;
                System.out.printf("Yes!"+" "+"%.2f",haveMoney);
                System.out.println(" lv left.");

            } else {
                double noMoney=dubai-ebitda;
                System.out.printf("Not enough money!"+" "+"%.2f",noMoney);
                System.out.print(" lv needed.");
            }
            }
        if (totalOrder < 50) {
            double rent1=totalSale*0.10;
            double ebitda1=totalSale-rent1;
        if (dubai <= ebitda1) {
            double haveMoney1=ebitda1-dubai;
            System.out.printf("Yes!"+" "+"%.2f",haveMoney1);
            System.out.println(" lv left.");

        } else {
            double noMoney1=dubai-ebitda1;
            System.out.printf("Not enough money!"+" "+"%.2f",noMoney1);
            System.out.print(" lv needed.");
        }

        }
    }}




















