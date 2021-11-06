import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        StringBuilder reversed= new StringBuilder();

        while (!line.equals("end")) {


            for (int i = line.length() - 1; i >= 0; i--) {
                reversed.append(line.charAt(i));
            }
            System.out.printf("%s = %s%n",line, reversed.toString());
            reversed = new StringBuilder();


            line = scanner.nextLine();
        }



    }
}
