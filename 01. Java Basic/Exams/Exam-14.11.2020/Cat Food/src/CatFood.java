import java.util.Scanner;

public class CatFood {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCat=Integer.parseInt(scanner.nextLine());

        int small=0;
        int medium=0;
        int large=0;
        int totalFood=0;
        double price=0;


        for (int i = 1; i <=numCat ; i++) {
            double food=Double.parseDouble(scanner.nextLine());
            totalFood+=food;

            double totalFoodKg=totalFood/1000.00;

            price=totalFoodKg*12.45;


            if(food>=100&&food<200){
                small++;
            }else if(food>=200&&food<300){
                medium++;
            }else if(food>=300&&food<400){
                large++;
            }

        }

        System.out.printf("Group 1: %d cats.%n",small);
        System.out.printf("Group 2: %d cats.%n",medium);
        System.out.printf("Group 3: %d cats.%n",large);
        System.out.printf("Price for food per day: %.2f lv.",price);






















    }
}
