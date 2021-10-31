import java.util.Scanner;

public class FootballTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name=scanner.nextLine();
        int playGame=Integer.parseInt(scanner.nextLine());
        if(playGame==0){
            System.out.printf("%s hasn't played any games during this season.",name);
            return;
        }

        int victoryCounter=0;
        int jealousyCounter=0;
        int loseCounter=0;

        for (int i = 1; i <=playGame ; i++) {
            String currentResult=scanner.nextLine();
            switch (currentResult){
                case "W":
                    victoryCounter++;
                    break;
                case "D":
                    jealousyCounter++;
                    break;
                case "L":
                    loseCounter++;
                    break;
            }

        }
        int victory=victoryCounter*3;
        int jealousy=jealousyCounter;
        int lose=0;

        int totalActive=victory+jealousy+lose;
        double successRate=(1.0*victoryCounter/playGame)*100;

        System.out.printf("%s has won %d points during this season.%n",name,totalActive);
        System.out.println("Total stats:");
        System.out.printf("## W: %d%n",victoryCounter);
        System.out.printf("## D: %d%n",jealousyCounter);
        System.out.printf("## L: %d%n",loseCounter);
        System.out.printf("Win rate: %.2f%%",successRate);




















    }
}
