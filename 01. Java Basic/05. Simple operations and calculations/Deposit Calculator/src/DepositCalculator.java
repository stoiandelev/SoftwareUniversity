import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        double depositSum=Double.parseDouble(scanner.nextLine());
        int month=Integer.parseInt(scanner.nextLine());
        double yearPercent=Double.parseDouble(scanner.nextLine());

        double natrupanaLihva=depositSum*(yearPercent/100);
        double lihvaforMonth=natrupanaLihva/12;
        double tatalLeva=depositSum+(month*lihvaforMonth);

        System.out.println(tatalLeva);







    }
}
