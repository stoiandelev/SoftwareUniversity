import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {

            String barcodes = scanner.nextLine();

            String validBarcodesRegex = "@#+(?<product>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
            Pattern pattern = Pattern.compile(validBarcodesRegex);
            Matcher matcher = pattern.matcher(barcodes);


            if (matcher.find()) {
                String product = matcher.group("product");
                String productGroup = "";

                for (int index = 0; index < product.length(); index++) {
                    char currentSymbol = product.charAt(index);
                    if (Character.isDigit(currentSymbol)) {
                        productGroup += currentSymbol;
                    }

                }
                if (productGroup.equals("")) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + productGroup);
                }


            } else {
                System.out.println("Invalid barcode");
            }

        }


    }
}
