import java.util.Scanner;

public class CareOfPuppy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int food=Integer.parseInt(scanner.nextLine());
        String foodInGram=scanner.nextLine();
        int needFood=0;
        int foodInGramReal=food*1000;

        while (!foodInGram.equals("Adopted")){
            int currentFood=Integer.parseInt(foodInGram);
            needFood+=currentFood;
            foodInGram=scanner.nextLine();


        }
        int remainedFood=foodInGramReal-needFood;
        int needFoodReal=Math.abs(needFood-foodInGramReal);
        if(needFood<=foodInGramReal){
            System.out.printf("Food is enough! Leftovers: %d grams.",remainedFood);
        }else{
            System.out.printf("Food is not enough. You need %d grams more.",needFoodReal);
        }















    }
}
