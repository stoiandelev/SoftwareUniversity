import java.util.*;

public class ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number=Integer.parseInt(scanner.nextLine());

        List<String> product = new ArrayList<>();
        for (int i = 0; i <number ; i++) {
            product.add(scanner.nextLine());

        }
        Collections.sort(product);
        

        for (int i = 0; i <product.size() ; i++) {
            System.out.printf("%d.%s%n",i+1,product.get(i));

        }

    }

}
