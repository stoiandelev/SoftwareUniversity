import java.util.Scanner;

public class TennisRanklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num=Integer.parseInt(scanner.nextLine());
        int point=Integer.parseInt(scanner.nextLine());
        int currentPoint=0;
        int countVictory=0;
        int countAverage=0;

        for (int i = 1; i <=num ; i++) {
            String etap=scanner.nextLine();

            if(etap.equals("W")){
                currentPoint=2000;
                countAverage+=currentPoint;
                countVictory++;
                point=point+currentPoint;
            }else if(etap.equals("F")){
                currentPoint=1200;
                countAverage+=currentPoint;
                point=point+currentPoint;
            }else {
                currentPoint=720;
                countAverage+=currentPoint;
                point=point+currentPoint;
            }

        }
        double averagePoint=1.0*countAverage/num;
        averagePoint=Math.floor(averagePoint);
        double averageWin=1.0*countVictory/num*100;

        System.out.printf("Final points: %d%n",point);
        System.out.printf("Average points: %.0f%n",averagePoint);
        System.out.printf("%.2f%%",averageWin);




    }

}
