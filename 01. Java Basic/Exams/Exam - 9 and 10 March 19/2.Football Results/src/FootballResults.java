import java.util.Scanner;

public class FootballResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String game1=scanner.nextLine();
        String game2=scanner.nextLine();
        String game3=scanner.nextLine();

        int countVictory=0;
        int countRavenstvo=0;
        int countLose=0;


            char gameFirst=game1.charAt(0);
            char gameSecond=game1.charAt(2);

            if(gameFirst>gameSecond){
                countVictory++;
            }else if(gameFirst<gameSecond){
                countLose++;
            }else {
                countRavenstvo++;
            }

        char gameFirst1=game2.charAt(0);
        char gameSecond1=game2.charAt(2);

        if(gameFirst1>gameSecond1){
            countVictory++;
        }else if(gameFirst1<gameSecond1){
            countLose++;
        }else {
            countRavenstvo++;
        }

        char gameFirst2=game3.charAt(0);
        char gameSecond2=game3.charAt(2);

        if(gameFirst2>gameSecond2){
            countVictory++;
        }else if(gameFirst2<gameSecond2){
            countLose++;
        }else {
            countRavenstvo++;
        }







        System.out.printf("Team won %d games.%n",countVictory);
        System.out.printf("Team lost %d games.%n",countLose);
        System.out.printf("Drawn games: %d",countRavenstvo);



    }
}
