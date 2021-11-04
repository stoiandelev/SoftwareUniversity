import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int repeat = Integer.parseInt(scanner.nextLine());

        String repeatedText=repeatString(text,repeat);
        System.out.println(repeatedText);


    }

    private static String repeatString(String text, int repeat) {
        StringBuilder result=new StringBuilder();
        for (int i = 0; i <repeat ; i++) {
            result.append(text);
        }
        return result.toString();
    }
}