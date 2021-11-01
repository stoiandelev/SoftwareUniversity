import java.util.Scanner;

public class FoodForPets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int day=Integer.parseInt(scanner.nextLine());//храната за дните
        double totalFoods=Double.parseDouble(scanner.nextLine());//общата храна
        //минаваме през всички дни

        double totalBiscuit=0;
        double totalFoodDog=0;
        double totalFoodCat=0;

        for (int i =1; i <=day ; i++) {
            int foodDog=Integer.parseInt(scanner.nextLine());
            totalFoodDog+=foodDog;
            int foodCat=Integer.parseInt(scanner.nextLine());
            totalFoodCat+=foodCat;

            //бисквитите на кучето и котката
            if(i%3==0){
                totalBiscuit+=(foodCat+foodDog)*0.10;

            }

        }
        double totalEatFood=totalFoodCat+totalFoodDog;
        double presentEatFood=(totalEatFood/totalFoods)*100;

        System.out.printf("Total eaten biscuits: %.0fgr.%n",totalBiscuit);
        System.out.printf("%.2f%% of the food has been eaten.%n",presentEatFood);
        System.out.printf("%.2f%% eaten from the dog.%n",(totalFoodDog/totalEatFood)*100);
        System.out.printf("%.2f%% eaten from the cat.%n",(totalFoodCat/totalEatFood)*100);
















    }
}
