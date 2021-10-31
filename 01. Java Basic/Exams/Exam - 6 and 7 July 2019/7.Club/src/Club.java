import java.util.Scanner;

public class Club {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double needProfit=Double.parseDouble(scanner.nextLine());
        String input=scanner.nextLine();


        double cocktailPrice=0;
        double earnedMoney=0;


        while (!input.equals("Party!")){
            String cocktailName=input;
            double price=input.length();
            input=scanner.nextLine();
            int number=Integer.parseInt(input);
            cocktailPrice=price*number;

            if(cocktailPrice%2!=0){
                cocktailPrice=cocktailPrice*0.75;
            }
            earnedMoney+=cocktailPrice;

            if(earnedMoney>=needProfit){
                System.out.println("Target acquired.");
                System.out.printf("Club income - %.2f leva.",earnedMoney);
                break;
            }
            input=scanner.nextLine();
        }


        if(input.equals("Party!")){
            System.out.printf("We need %.2f leva more.%n",needProfit-earnedMoney);
            System.out.printf("Club income - %.2f leva.",earnedMoney);
        }



    }
}
