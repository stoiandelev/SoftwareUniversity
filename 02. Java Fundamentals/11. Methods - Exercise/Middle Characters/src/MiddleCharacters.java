import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text=scanner.nextLine();

        printMiddleCharacter(text);


    }

    private static void printMiddleCharacter(String text) {

       char letter=text.charAt(text.length() / 2);

       if(text.length() % 2 == 0 ) {
           char letter2 = text.charAt(text.length() / 2 - 1);
           System.out.print(letter2);
       }
        System.out.println(letter);

    }
}
