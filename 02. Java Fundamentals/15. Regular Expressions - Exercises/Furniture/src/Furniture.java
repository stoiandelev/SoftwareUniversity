import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "(?<furniture>\\w+)<<(?<price>[0-9]+.?[0-9]+)!(?<quantity>\\d+)";

        Pattern pattern = Pattern.compile(regex);
        List<String> furnitures = new ArrayList<>();
        double totalSpendMoney = 0;
        while (!(input.equals("Purchase"))) {

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String furniture = matcher.group("furniture");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                furnitures.add(furniture);
                totalSpendMoney += price * quantity;

            }
            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        furnitures.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", totalSpendMoney);
    }
}
