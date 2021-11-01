import java.util.Scanner;

public class EasterLunch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int kozunaci=Integer.parseInt(scanner.nextLine());
        int qica=Integer.parseInt(scanner.nextLine());
        int kurabii=Integer.parseInt(scanner.nextLine());

        double priceKozunaci=3.20;
        double priceQica=4.35;
        double priceKurabii=5.40;
        double priceBoq=0.15;

        double totalKuzunaci=kozunaci*priceKozunaci;
        double totalQica=qica*priceQica;
        double totalKurabii=kurabii*priceKurabii;
        double totalKBoq=qica*12*priceBoq;

        double totalPrice=totalKuzunaci+totalQica+totalKurabii+totalKBoq;

        System.out.printf("%.2f",totalPrice);













    }
}
