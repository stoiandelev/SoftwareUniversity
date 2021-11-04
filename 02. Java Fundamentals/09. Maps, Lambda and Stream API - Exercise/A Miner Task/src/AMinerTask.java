import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resource = scanner.nextLine();
        Map<String, Integer> resourceQuantity = new LinkedHashMap<>();

        while (!resource.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resourceQuantity.containsKey(resource)) {
                resourceQuantity.put(resource, quantity);
            } else {
                resourceQuantity.put(resource, resourceQuantity.get(resource) + quantity);
            }


            resource = scanner.nextLine();
        }
        resourceQuantity.forEach((k, v) -> System.out.println(k + " -> " + v));

    }
}
