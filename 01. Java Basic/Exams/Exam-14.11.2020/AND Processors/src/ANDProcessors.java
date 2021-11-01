import java.util.Scanner;

public class ANDProcessors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numProcessor=Integer.parseInt(scanner.nextLine());
        int numStaff=Integer.parseInt(scanner.nextLine());
        int days=Integer.parseInt(scanner.nextLine());

        double loseCompany=0;
        double winCompany=0;

        double totalHaurs=numStaff*days*8;
        double work=Math.floor(totalHaurs/3);

        if(work<numProcessor){
            double lose=numProcessor-work;
            loseCompany=lose*110.10;
            System.out.printf("Losses: -> %.2f BGN",loseCompany);
        }else{
            double win=work-numProcessor;
            winCompany=win*110.10;
            System.out.printf("Profit: -> %.2f BGN",winCompany);
        }











    }
}
