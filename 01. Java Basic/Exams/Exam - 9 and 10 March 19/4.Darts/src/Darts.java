import java.util.Scanner;

public class Darts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        double score = 301;
        double successfulShots = 0;
        double unsuccessfulShots = 0;

        String type = scanner.nextLine();
        while (!type.equals("Retire")) {


            int points = Integer.parseInt(scanner.nextLine());

            if (type.equals("Single")) {
                score -= points;
                if (score >= 0) {
                    successfulShots++;
                } else {
                    unsuccessfulShots++;
                    score += points;
                }
            } else if (type.equals("Double")) {
                score -= points * 2;
                if (score >= 0) {
                    successfulShots++;
                } else {
                    unsuccessfulShots++;
                    score += points * 2;
                }
            } else if (type.equals("Triple")) {
                score -= points * 3;
                if (score >= 0) {
                    successfulShots++;
                } else {
                    unsuccessfulShots++;
                    score += points * 3;
                }
            }

            if (score == 0) {
                System.out.printf("%s won the leg with %.0f shots.", name, successfulShots);
                break;
            }


            type = scanner.nextLine();
        }

        if ((type.equals("Retire"))) {
            System.out.printf("%s retired after %.0f unsuccessful shots.",name,unsuccessfulShots);
        }


    }
}
