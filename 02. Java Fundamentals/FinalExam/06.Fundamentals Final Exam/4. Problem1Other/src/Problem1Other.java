import java.util.Scanner;

public class Problem1Other {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String test = scanner.nextLine();
        String input;

        while (!"Sign up".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(" ");
            switch (tokens[0]) {
                case "Case":
                    switch (tokens[1]) {
                        case "lower":
                            test = test.toLowerCase();
                            System.out.println(test);
                            break;
                        case "upper":
                            test = test.toUpperCase();
                            System.out.println(test);
                            break;
                    }
                    break;
                case "Reverse":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex >= 0 && startIndex < test.length() && endIndex > 0 && endIndex < test.length()) {
                        String reverse = test.substring(startIndex, endIndex + 1);
                        char[] charArr = reverse.toCharArray();
                        for (int i = charArr.length - 1; i >= 0; i--) {
                            System.out.print(charArr[i]);

                        }
                        System.out.println();
                    }
                    break;
                case "Cut":
                    if (test.contains(tokens[1])) {
                        test = test.replace(tokens[1], "");
                        System.out.println(test);
                    } else {
                        System.out.printf("The word %s doesn't contain %s.\n", test, tokens[1]);
                    }
                    break;
                case "Replace":
                    test = test.replace(tokens[1], "*");
                    System.out.println(test);
                    break;
                case "Check":
                    if (test.contains(tokens[1])) {
                        System.out.println("Valid");
                    } else {
                        System.out.printf("Your username must contain %s.\n", tokens[1]);
                    }
                    break;
            }
        }
    }
}


