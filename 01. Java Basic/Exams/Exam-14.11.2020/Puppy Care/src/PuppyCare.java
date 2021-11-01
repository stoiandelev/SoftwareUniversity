import java.util.Scanner;

public class PuppyCare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int byuFoodKg=Integer.parseInt(scanner.nextLine());
        String food=scanner.nextLine();
        int totalFood=0;


        while (!food.equals("Adopted")){
            int currentFood=Integer.parseInt(food);
            totalFood+=currentFood;



            food=scanner.nextLine();


        }
        int totalFoodGrama=byuFoodKg*1000;

        if(totalFood<=totalFoodGrama){
            System.out.printf("Food is enough! Leftovers: %d grams.",totalFoodGrama-totalFood);
        }else {
            System.out.printf("Food is not enough. You need %d grams more.",totalFood-totalFoodGrama);
        }




















    }
}
