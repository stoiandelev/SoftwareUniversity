
import java.util.Scanner;

public class GameNumberWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String playerOne = scanner.nextLine();
        String playerTwo = scanner.nextLine();

        int pointsPlayerOne = 0;
        int pointsPlayerTwo = 0;

        String input = scanner.nextLine();
        while (!"End of game".equals(input)) {

            int firstCard = Integer.parseInt(input);
            int secondCard = Integer.parseInt(scanner.nextLine());


            if (firstCard > secondCard) {

                pointsPlayerOne += firstCard - secondCard;

            } else if (firstCard < secondCard) {

                pointsPlayerTwo += secondCard - firstCard;

            } else {

                while (true) {

                    firstCard = Integer.parseInt(scanner.nextLine());
                    secondCard = Integer.parseInt(scanner.nextLine());
                    if (firstCard > secondCard) {

                        System.out.printf("Number wars!%n%s is winner with %d points%n", playerOne, pointsPlayerOne);
                        break;

                    } else if (firstCard < secondCard) {

                        System.out.printf("Number wars!%n%s is winner with %d points%n", playerTwo, pointsPlayerTwo);
                        break;

                    }
                }
                break;
            }
            input = scanner.nextLine();
        }
        if ("End of game".equals(input)) {
            System.out.printf("%s has %d points%n%s has %d points%n", playerOne, pointsPlayerOne, playerTwo, pointsPlayerTwo);
        }
    }
}



