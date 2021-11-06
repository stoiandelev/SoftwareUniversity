import java.util.Scanner;

public class Problem1Oleg {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String message = scan.nextLine();

        String command = scan.nextLine();
        while (!command.equals("Finish")) {
            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {

                case "Replace":{
                    String currentChar = tokens[1];
                    String newChar = tokens[2];

                    message = message.replace(currentChar, newChar);
                    System.out.println(message);
                    break;}

                case "Cut":{
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (isValidIndex(startIndex, message) && isValidIndex(endIndex, message)) {

                        StringBuilder msgSb = new StringBuilder(message);
                        message = msgSb.delete(startIndex, endIndex + 1).toString();
                        System.out.println(message);

                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;}
                case "Make":{
                    String type = tokens[1];
                    if (type.equals("Upper")) {
                        message = message.toUpperCase();
                    } else if (type.equals("Lower")) {
                        message = message.toLowerCase();
                    }
                    System.out.println(message);
                    break;}
                case "Check":{
                    String strToCheck = tokens[1];
                    if (message.contains(strToCheck)){
                        System.out.println("Message contains " + strToCheck);
                    }else{
                        System.out.println("Message doesn't contain " + strToCheck);
                    }
                    break;}
                case "Sum":{
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (isValidIndex(startIndex, message) && isValidIndex(endIndex, message)){
                        int sum = getSumOfASCI(message.substring(startIndex,endIndex+1));
                        System.out.println(sum);

                    } else {
                        System.out.println("Invalid indices!");
                    }

                    break;}
            }
            command = scan.nextLine();
        }
    }

    private static int getSumOfASCI(String substring) {
        int sum = 0;
        for (int i = 0; i <substring.length() ; i++) {
            char currentChar = substring.charAt(i);
            sum+=currentChar;
        }
        return sum;
    }

    private static boolean isValidIndex(int index, String string) {
        return (index >= 0 && index <= string.length() - 1);

    }
}