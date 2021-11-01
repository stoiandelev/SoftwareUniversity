import java.util.Scanner;

public class CatWalking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minute=Integer.parseInt(scanner.nextLine());
        int countWalk=Integer.parseInt(scanner.nextLine());
        int calorie=Integer.parseInt(scanner.nextLine());

        int totalMinute=minute*countWalk;
        int totalCalories=totalMinute*5;
        int totalCaloriesDay=calorie/2;

        if(totalCalories>=totalCaloriesDay){
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.",totalCalories);
        }else{
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.",totalCalories);
        }














    }
}
