import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        //["Create", "{}", "{}", "{}"]
        List<String> data = Arrays.stream(scanner.nextLine().split("\\s+"))
                .skip(1).collect(Collectors.toList());

        ListyIterator listyIterator = new ListyIterator(data);

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            switch (command) {
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (Exception e) {
                        System.out.println("Invalid Operation!");
                    }

                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
            }
            command = scanner.nextLine();
        }

    }
}
