import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text=scanner.nextLine();
        String regex="([|#])(?<product>[A-Za-z ]+)\\1(?<BestBefore>[0-9][0-9][\\/][0-9][0-9][\\/][0-9][0-9])\\1(?<calories>[0-9]+)\\1";

        Pattern pattern= Pattern.compile(regex);
        Matcher matcher=pattern.matcher(text);

        List<String> allGoods=new ArrayList<>();


        int total=0;

        while (matcher.find()){
            allGoods.add(String.format("Item: %s, Best before: %s, Nutrition: %s",
                    matcher.group("product"), matcher.group("BestBefore"), matcher.group("calories")));
            total += Integer.parseInt(matcher.group("calories"));


        }

        int day =total/2000;
        System.out.println("You have food to last you for: " + day + " days!");
        for (String s : allGoods) {
            System.out.println(s);
        }
    }
}
