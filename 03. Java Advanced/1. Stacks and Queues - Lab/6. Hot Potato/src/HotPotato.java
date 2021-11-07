import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<String> kids = new ArrayDeque<>();
        Collections.addAll(kids, input);

        int n = Integer.parseInt(scanner.nextLine());


        while (kids.size() > 1) {
            for (int j = 1; j < n; j++) {
                kids.offer(kids.poll());
            }
            System.out.println("Removed " + kids.poll());
        }

        System.out.println("Last is " + kids.pop());
    }
}