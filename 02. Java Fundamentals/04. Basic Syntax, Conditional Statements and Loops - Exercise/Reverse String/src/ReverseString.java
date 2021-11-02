import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input=scanner.nextLine();

        for (int position =input.length()-1; position >=0 ; position--) {
            char currentSymbol=input.charAt((position));
            System.out.print(currentSymbol);
        }


















    }
}
