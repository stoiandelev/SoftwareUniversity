import java.util.Scanner;

public class OscarsCeremony {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int rent=Integer.parseInt(scanner.nextLine());

        double statuetki=rent*0.70;
        double ketering=statuetki*0.85;
        double music=ketering/2;


        double totalCost=rent+statuetki+ketering+music;

        System.out.printf("%.2f",totalCost);





















    }
}
