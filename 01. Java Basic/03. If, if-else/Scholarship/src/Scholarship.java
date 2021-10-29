import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double income = Double.parseDouble(scanner.nextLine());
        double averageSuccess = Double.parseDouble(scanner.nextLine());
        double minimalSalary = Double.parseDouble(scanner.nextLine());

        double socialScholarship =0;
        double successScholarship = 0;

        if(income<=minimalSalary && averageSuccess>=4.5){
            socialScholarship=Math.floor(minimalSalary*0.35);
        }

        if(averageSuccess>=5.50){
            successScholarship=Math.floor(averageSuccess*25);
        }

        if(socialScholarship>successScholarship){
            System.out.printf("You get a Social scholarship %.0f BGN", socialScholarship);
        }
        else if(socialScholarship<successScholarship){
            System.out.printf("You get a scholarship for excellent results %.0f BGN",successScholarship);
        }
        else {
            System.out.println("You cannot get a scholarship!");
        }





    }
}