
import java.util.Scanner;

public class BirthayParty {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);


        int hallrent=Integer.parseInt(scanner.nextLine());

        double cake=(hallrent*20)/100;
        double drinks=cake-cake*45/100;
        int animator=hallrent/3;

        double budget=hallrent+cake+drinks+animator;
        System.out.println(budget);

    }
}
