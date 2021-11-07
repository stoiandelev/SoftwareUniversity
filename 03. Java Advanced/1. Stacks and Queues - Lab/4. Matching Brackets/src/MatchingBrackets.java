import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (currentChar == '(') {
                stack.push(i);
            } else if (currentChar == ')') {
                if (!stack.isEmpty()) {
                    int openingBracketIndex = stack.pop();

                    System.out.println(expression.substring(openingBracketIndex, i + 1));
                }
            }
        }
    }
}
