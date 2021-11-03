import java.util.Scanner;

public class CharstoString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char char1=scanner.next().charAt(0);
        char char2=scanner.next().charAt(0);
        char char3=scanner.next().charAt(0);

        System.out.printf("%c%c%c",char1,char2,char3);



    }
}
