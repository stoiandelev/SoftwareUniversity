import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] spitCommand = command.split("\\s+");
            String commandSwitch = spitCommand[0];

            switch (commandSwitch) {

                case "Translate":
                    String charName = spitCommand[1];
                    String toReplace = spitCommand[2];
                    text = new StringBuilder(text.toString().replaceAll(charName, toReplace));
                    System.out.println(text);
                    break;
                case "Includes":
                    String haveOrNot = spitCommand[1];
                    if (text.indexOf(haveOrNot) != -1) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Start":
                    String startString = spitCommand[1];
                    String toString = text.toString();
                    if (toString.contains(startString)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    text = new StringBuilder(toString);
                    break;
                case "Lowercase":
                    for (int i = 0; i < text.length(); i++) {
                        char currentChar = text.charAt(i);
                        text.setCharAt(i, Character.toLowerCase(currentChar));
                    }
                    System.out.println(text);
                    break;
                case "FindIndex":
                    String lastIndex = spitCommand[1];
                    int lastIndexInfo = text.lastIndexOf(lastIndex);
                    System.out.println(lastIndexInfo);


                    break;
                case "Remove":
                    int startRemove = Integer.parseInt(spitCommand[1]);
                    int countCharacter = Integer.parseInt(spitCommand[2]);

                    String toStringRemove = text.toString();
                    toStringRemove = toStringRemove.substring(0,startRemove)+toStringRemove.substring(startRemove+countCharacter);

                    text = new StringBuilder(toStringRemove);
                    
                    System.out.println(text);
                    break;
            }


            command = scanner.nextLine();
        }
    }
}
