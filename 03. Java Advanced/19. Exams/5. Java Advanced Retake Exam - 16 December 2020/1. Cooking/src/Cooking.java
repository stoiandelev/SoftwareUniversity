import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredientsStack::push);

        int bread = 0;
        int cake = 0;
        int pastry = 0;
        int fruitPie = 0;


        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int firstLiquid = liquidsQueue.peek();
            int firstIngredient = ingredientsStack.peek();

            if (firstLiquid + firstIngredient == 25) {
                liquidsQueue.poll();
                ingredientsStack.pop();
                bread += 1;
                continue;
            } else if (firstLiquid + firstIngredient == 50) {
                liquidsQueue.poll();
                ingredientsStack.pop();
                cake += 1;
                continue;
            } else if (firstLiquid + firstIngredient == 75) {
                liquidsQueue.poll();
                ingredientsStack.pop();
                pastry += 1;
                continue;
            } else if (firstLiquid + firstIngredient == 100) {
                liquidsQueue.poll();
                ingredientsStack.pop();
                fruitPie += 1;
                continue;
            }
            liquidsQueue.pop();
            int increaseIngredient = firstIngredient + 3;
            ingredientsStack.pop();
            ingredientsStack.push(increaseIngredient);


        }

        if (bread >= 1 && cake >= 1 && pastry >= 1 && fruitPie >= 1) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }

        System.out.println("Liquids left: " + getElementsInfo(liquidsQueue));
        System.out.println("Ingredients left: " + getElementsInfo(ingredientsStack));

        System.out.println("Bread: " + bread);
        System.out.println("Cake: " + cake);
        System.out.println("Fruit Pie: " + fruitPie);
        System.out.println("Pastry: " + pastry);

    }

    private static String getElementsInfo(ArrayDeque<Integer> deque) {
        return deque.isEmpty() ? "none" : deque.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

}
