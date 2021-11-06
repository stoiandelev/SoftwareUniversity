import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        StringBuilder encryptedText = new StringBuilder();

        for (int index = 0; index <= text.length() - 1; index++) {
            char currentChar = text.charAt(index);
            encryptedText.append((char) (currentChar + 3));
        }
        System.out.println(encryptedText.toString());


    }
}
