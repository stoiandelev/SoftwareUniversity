import java.util.Scanner;

public class EasterCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countKozunak=Integer.parseInt(scanner.nextLine());

        int totalEvaluation=0;
        int maxEvaluation=Integer.MIN_VALUE;
        String maxName="";

        for (int i = 1; i <=countKozunak ; i++) {

            String name=scanner.nextLine();

            String evaluation=scanner.nextLine();

            while (!evaluation.equals("Stop")){
                int currentEvaluation=Integer.parseInt(evaluation);
                totalEvaluation+=currentEvaluation;
                evaluation=scanner.nextLine();
            }
            System.out.printf("%s has %d points.%n",name,totalEvaluation);
            if(totalEvaluation>maxEvaluation){
                maxEvaluation=totalEvaluation;
                maxName=name;
                System.out.printf("%s is the new number 1!%n",name);
            }

            totalEvaluation=0;

        }
        System.out.printf("%s won competition with %d points!",maxName,maxEvaluation);

        
    }
}
