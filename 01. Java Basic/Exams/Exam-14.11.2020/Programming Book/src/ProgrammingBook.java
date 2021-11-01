import java.util.Scanner;

public class ProgrammingBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceForOnePage=Double.parseDouble(scanner.nextLine());
        double priceForOneKorica=Double.parseDouble(scanner.nextLine());
        int percentDiscount=Integer.parseInt(scanner.nextLine());
        double sumDizainer=Double.parseDouble(scanner.nextLine());
        int percentAllSum=Integer.parseInt(scanner.nextLine());


        double totalPriceOnePage=priceForOnePage*899+2*priceForOneKorica;


        double disountBefore=totalPriceOnePage-(totalPriceOnePage*(percentDiscount/100.0));

        double sellDizainer=disountBefore+sumDizainer;


        double team=sellDizainer-(sellDizainer*(percentAllSum/100.0));

        System.out.printf("Avtonom should pay %.2f BGN.",team);




        //double disount=totalPriceOnePage*(percentDiscount/100.00);
        //double disountBefore=totalPriceOnePage-disount;

        //double discount1=sellDizainer*(percentAllSum/100.00);
        //double team=sellDizainer-discount1;















    }
}
