import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;

public class TournamentOfChristmas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOfTournament = Integer.parseInt(scanner.nextLine());
        double charity = 0;
        double dayCharity = 0;
        int win = 0;
        int lose = 0;
        int dayWin = 0;
        int dayLose = 0;

        for (int i = 1; i <= daysOfTournament; i++) {
            String sport = scanner.nextLine();
            while (!sport.equals("Finish")) {
                String result = scanner.nextLine();
                switch (result) {
                    case "win":
                        win++;
                        dayCharity += 20;
                        break;
                    case "lose":
                        lose++;
                        break;
                }
                sport = scanner.nextLine();
            }
            if (win > lose) {
                dayCharity *= 1.10;
                dayWin++;
            } else {
                dayLose++;
            }
            win = 0;
            lose = 0;
            charity += dayCharity;
            dayCharity = 0;




        }
        if (dayWin > dayLose) {
            charity *= 1.20;
        }

        if (dayWin > dayLose) {
            System.out.printf("You won the tournament! Total raised money: %.2f", charity);
        } else {
            System.out.printf("You lost the tournament! Total raised money: %.2f", charity);
        }


    }
}
