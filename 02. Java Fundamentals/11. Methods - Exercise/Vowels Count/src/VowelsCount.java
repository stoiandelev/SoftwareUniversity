import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        int countSum = vowelsCount(text);
        System.out.println(countSum);
    }

    private static int vowelsCount(String text) {
        String currentText = text;
        int countSum = 0;
        for (int i = 0; i < currentText.length(); i++) {
            int currentIndex = currentText.charAt(i);

            if (currentIndex == 'A') {
                countSum++;
            } else if (currentIndex == 'a') {
                countSum++;
            }else if (currentIndex == 'E') {
                countSum++;
            }else if (currentIndex == 'e') {
                countSum++;
            }else if (currentIndex == 'I') {
                countSum++;
            }else if (currentIndex == 'i') {
                countSum++;
            }else if (currentIndex == 'O') {
                countSum++;
            }else if (currentIndex == 'o') {
                countSum++;
            }else if (currentIndex == 'U') {
                countSum++;
            }else if (currentIndex == 'u') {
                countSum++;
            }

        }
        return countSum;

    }
}

