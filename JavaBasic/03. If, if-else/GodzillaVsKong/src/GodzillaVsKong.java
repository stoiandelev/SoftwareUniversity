import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int numberOfExtras = Integer.parseInt((scanner.nextLine()));
        double clothesPrice = Double.parseDouble(scanner.nextLine());

        double decor = budget * 0.1;
        double sumForClothes = numberOfExtras * clothesPrice;
        double totalFilmSum = sumForClothes + decor;
        double moneyLeft=budget-totalFilmSum;

        if (numberOfExtras > 150) {
            sumForClothes = sumForClothes - (sumForClothes * 0.1);
            totalFilmSum = decor +sumForClothes;
            moneyLeft=budget-totalFilmSum;
        }

        if (budget >= totalFilmSum) {
            System.out.printf("Action!\nWingard starts filming with "+ "%.2f",moneyLeft);
            System.out.print(" leva left.");
        }
        if(budget<totalFilmSum){
            System.out.printf("Not enough money!\nWingard needs " +"%.2f",+Math.abs(moneyLeft));
            System.out.print(" leva more.");
        }







    }
}