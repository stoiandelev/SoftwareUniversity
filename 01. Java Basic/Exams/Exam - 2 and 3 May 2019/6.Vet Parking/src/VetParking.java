import java.util.Scanner;

public class VetParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days=Integer.parseInt(scanner.nextLine());
        int hours=Integer.parseInt(scanner.nextLine());
        double tax=0;
        double totalTax=0;
        double allTax=0;


        for (int i = 1; i <=days ; i++) {
            for (int j = 1; j <=hours ; j++) {

                if(i%2==0&&j%2!=0){
                    tax=2.50;
                    totalTax+=tax;
                }else if(i%2!=0&&j%2==0){
                    tax=1.25;
                    totalTax+=tax;
                }else {
                    tax=1.00;
                    totalTax+=tax;
                }


            }
            allTax+=totalTax;
            System.out.printf("Day: %d - %.2f leva%n",i,totalTax);
            totalTax=0;

        }
        System.out.printf("Total: %.2f leva",allTax);




























    }
}
