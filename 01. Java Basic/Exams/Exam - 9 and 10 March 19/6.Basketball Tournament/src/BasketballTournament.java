import java.util.Scanner;

public class BasketballTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name=scanner.nextLine();
        int countGame=0;
        int currentPoint=0;
        int win=0;
        int lose=0;
        int game=0;



        while (!name.equals("End of tournaments")) {

            game = Integer.parseInt(scanner.nextLine());


            for (int i = 1; i <= game; i++) {
                int point1 = Integer.parseInt(scanner.nextLine());
                int point2 = Integer.parseInt(scanner.nextLine());


                if (point1 > point2) {
                    currentPoint = point1 - point2;
                    countGame++;
                    System.out.printf("Game %d of tournament %s: win with %d points.%n", countGame, name, currentPoint);
                    win++;
                } else if (point1 < point2) {
                    countGame++;
                    currentPoint = Math.abs(point1 - point2);
                    System.out.printf("Game %d of tournament %s: lost with %d points.%n", countGame, name, currentPoint);
                    lose++;
                }


            }
            countGame = 0;
            name = scanner.nextLine();
        }


        int totalGame=win+lose;

        double totalWin=1.0*win/totalGame*100;
        double totalLose=1.0*lose/totalGame*100;

        System.out.printf("%.2f%% matches win%n",totalWin);
        System.out.printf("%.2f%% matches lost",totalLose);









    }
}
