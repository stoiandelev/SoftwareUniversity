import java.util.Scanner;

public class ChangeBureau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       double bitcoint=1168;
       double uoan=0.15;
       double dollar=1.76;
       double evro=1.95;
       double leva=0;

       double countBicointLeva=Integer.parseInt(scanner.nextLine());
       double countUoan=Double.parseDouble(scanner.nextLine());
       double commission=Double.parseDouble(scanner.nextLine());

       double result=0;


       countBicointLeva=bitcoint*countBicointLeva;
       countUoan=countUoan*uoan;
       leva=countUoan*dollar;

       result=countBicointLeva+leva;

       result=result/1.95;
       commission=result*(commission/100);

       result=result-commission;

        System.out.printf("%.2f",result);







    }
}
