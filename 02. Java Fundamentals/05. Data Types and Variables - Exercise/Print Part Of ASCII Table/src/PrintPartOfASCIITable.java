import java.util.Scanner;

public class PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstCharacter = Integer.parseInt(scanner.nextLine());
        int lastCharacter = Integer.parseInt(scanner.nextLine());

        for (int i = firstCharacter; i <= lastCharacter; i++) {
            System.out.print((char) i+" ");
        }
    }
}
