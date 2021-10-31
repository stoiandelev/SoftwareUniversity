import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget=Double.parseDouble(scanner.nextLine());
        String seasons=scanner.nextLine();


        String destination="";
        String vacation="";
        double sum=0;


        if(budget<=100){
            destination=("Bulgaria");
            if(seasons.equals("summer")){
                vacation="Camp";
                sum=budget*0.3;
            }else{
                vacation="Hotel";
                sum=budget*0.7;
            }
        }

        if(budget<=1000&&budget>100){
            destination="Balkans";
            if(seasons.equals("summer")){
                vacation="Camp";
                sum=budget*0.4;
            }else{
                vacation="Hotel";
                sum=budget*0.8;
            }
        }

        if(budget>1000){
            destination="Europe";
            vacation="Hotel";
            sum=budget*0.9;
        }

        System.out.println("Somewhere in "+ destination);
        System.out.printf(vacation+" - "+"%.2f",sum);






    }
}
