import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> vip = new TreeSet<>();
        TreeSet<String> regular = new TreeSet<>();

        String input = scanner.nextLine();
        while (!input.equals("PARTY")) {

            if (Character.isDigit(input.charAt(0))) {
                vip.add(input);
            } else {
                regular.add(input);
            }

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("END")) {

            if (Character.isDigit(input.charAt(0))) {
                vip.remove(input);
            } else {
                regular.remove(input);
            }

            input = scanner.nextLine();
        }

        System.out.println(vip.size() + regular.size());

        if (!vip.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), vip));
        }
        if (!regular.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), regular));
        }
    }
}
