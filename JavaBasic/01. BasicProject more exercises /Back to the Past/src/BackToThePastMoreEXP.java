import java.util.Scanner;

public class BackToThePastMoreEXP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double heritage = Double.parseDouble(scanner.nextLine());
        int yearToLive = Integer.parseInt(scanner.nextLine());

        double yearsOld = 18;
        int diff=yearToLive-1800;

        for (int i = 0; i <= diff; i++) {

            if (i % 2 == 0) {
                heritage = heritage - 12000;
            } else {
                heritage = heritage - (12000 + (50 * yearsOld));
            }
            yearsOld++;

        }


        if(heritage>=0){
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.",heritage);
        }else{
            System.out.printf("He will need %.2f dollars to survive.",Math.abs(heritage));
        }


    }
}
