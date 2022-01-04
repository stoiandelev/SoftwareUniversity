import java.util.*;
import java.util.stream.Collectors;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split(", "))
                .map(Integer::parseInt)
                .forEach(liliesStack::push);


        ArrayDeque<Integer> rosesQueue = Arrays.stream(scanner.nextLine()
                .split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int goal = 5;
        int wreath = 0;

        int flowersLeft = 0;


        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {
            int firstLilies = liliesStack.peek();
            int firstRoses = rosesQueue.peek();

            if (firstLilies + firstRoses == 15) {
                wreath++;
                liliesStack.pop();
                rosesQueue.poll();
                continue;
            } else if (firstLilies + firstRoses > 15) {
                int currentLilies = firstLilies - 2;
                liliesStack.poll();
                liliesStack.push(currentLilies);
                continue;
            } else if (firstLilies + firstRoses < 15) {
                flowersLeft += firstLilies;
                flowersLeft += firstRoses;
                liliesStack.pop();
                rosesQueue.poll();
            }


        }
        int getMoreWreath = flowersLeft / 15;
        wreath += getMoreWreath;


        if (wreath >= goal) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreath);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", goal - wreath);
        }


    }
}
