import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> malesStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(malesStack::push);

        ArrayDeque<Integer> femaleQueue = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int matches = 0;

        while (!malesStack.isEmpty() && !femaleQueue.isEmpty()) {
            int firstMale = malesStack.peek();
            int firstFemale = femaleQueue.peek();

            if (firstMale <= 0) {
                malesStack.pop();
                continue;
            } else if (firstFemale <= 0) {
                femaleQueue.poll();
                continue;

            } else if (firstMale % 25 == 0) {
                malesStack.pop();
                malesStack.pop();
                continue;
            } else if (firstFemale % 25 == 0) {
                femaleQueue.poll();
                femaleQueue.poll();
                continue;
            }


            if (firstMale == firstFemale) {
                matches++;
                malesStack.pop();
                femaleQueue.poll();
            } else if (!femaleQueue.isEmpty() && !malesStack.isEmpty()) {
                femaleQueue.poll();
                int currentValue = malesStack.pop() - 2;
                malesStack.push(currentValue);
            }


        }

        //Matches: 3
        //Males left: 1
        //Females left: none

        System.out.println("Matches: " + matches);
        System.out.println("Males left: " + getElementsInfo(malesStack));
        System.out.println("Females left: " + getElementsInfo(femaleQueue));


    }
    private static String getElementsInfo(ArrayDeque<Integer> deque) {
        return deque.isEmpty() ? "none" : deque.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

}
