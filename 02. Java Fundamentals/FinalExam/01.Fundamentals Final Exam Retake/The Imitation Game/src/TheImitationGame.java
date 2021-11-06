import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equals("Decode")) {
            String[] token = command.split("\\|");
            String commandName = token[0];

            switch (commandName) {
                case "Move":
                    //Move {number of letters}
                    int numberOfLetters = Integer.parseInt(token[1]);
                    input = new StringBuilder(input.substring(numberOfLetters) +
                            input.substring(0, numberOfLetters));

                    break;
                case "Insert":
                    //Insert {index} {value}
                    int index = Integer.parseInt(token[1]);
                    String value = token[2];

                    input.insert(index, value);

                    break;
                case "ChangeAll":
                    //ChangeAll {substring} {replacement}
                    String substring = token[1];
                    String replacement = token[2];

                    input = new StringBuilder(input.toString().replace(substring,replacement));


                    break;

            }


            command = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s", input);


    }
}
