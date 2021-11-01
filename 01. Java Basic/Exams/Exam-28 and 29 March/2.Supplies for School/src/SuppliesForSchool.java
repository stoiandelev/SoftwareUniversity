import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum=0;

        int pen=Integer.parseInt(scanner.nextLine());
        int mark=Integer.parseInt(scanner.nextLine());
        double chemical=Double.parseDouble(scanner.nextLine());
        int percentDiscount=Integer.parseInt(scanner.nextLine());

        double pricePen=pen*5.80;
        double priceMark=mark*7.20;
        double priceChemical=chemical*1.20;

        sum=pricePen+priceMark+priceChemical;

        double sumWithDiscount=sum-((1.0*percentDiscount*sum)/100);



        System.out.printf("%.3f",sumWithDiscount);












    }
}
