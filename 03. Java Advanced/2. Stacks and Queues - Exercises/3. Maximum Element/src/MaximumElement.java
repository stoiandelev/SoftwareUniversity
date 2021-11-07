import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();

            //"1 X" - Push the element X into the stack.
            //"2" - Delete the element present at the top of the stack.
            //"3" - Print the maximum element in the stack.

            if (command.equals("2")) {
                stack.pop();
            } else if (command.equals("3")) {
                if (!stack.isEmpty()) {
                    System.out.println(Collections.max(stack));
                }
            } else if (command.split(" ")[0].equals("1")) {
                int pushElement = Integer.parseInt(command.split(" ")[1]);
                stack.push(pushElement);
            }
        }


    }
}
