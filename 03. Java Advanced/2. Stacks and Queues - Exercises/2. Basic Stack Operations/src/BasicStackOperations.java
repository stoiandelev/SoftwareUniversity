import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfElementToPush = scanner.nextInt();
        int numberOfElementToPop = scanner.nextInt();
        int numberOfElementToContent = scanner.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int count = 0; count < numberOfElementToPush; count++) {
            stack.push(scanner.nextInt());
        }

        for (int elementToPop = 0; elementToPop < numberOfElementToPop; elementToPop++) {
            stack.pop();
        }

        if (stack.contains(numberOfElementToContent)) {
            System.out.println("true");
        } else {
            if (!stack.isEmpty()) {
                System.out.println(Collections.min(stack));
            } else {
                System.out.println("0");
            }
        }


    }
}
