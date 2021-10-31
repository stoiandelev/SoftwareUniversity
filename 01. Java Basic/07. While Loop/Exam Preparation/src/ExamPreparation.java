import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lowEvaluation=Integer.parseInt(scanner.nextLine());
        int countLowEvaluation=0;
        int counterTask=0;
        double gradeSum=0;
        String lastTask="";
        boolean isFailed=false;


        while(countLowEvaluation<lowEvaluation){
            String currentTask=scanner.nextLine();
            if(currentTask.equals("Enough")){
                isFailed=true;
                break;
            }
            int grade=Integer.parseInt(scanner.nextLine());
            if(grade<=4){
                countLowEvaluation++;
            }
            gradeSum+=grade;
            counterTask++;
            lastTask=currentTask;

        }

        if(!isFailed){
            System.out.printf("You need a break, %d poor grades.",lowEvaluation);
        }else{
            double averages=gradeSum/counterTask;
            System.out.printf("Average score: %.2f%n",averages);
            System.out.printf("Number of problems: %d%n",counterTask);
            System.out.printf("Last problem: %s",lastTask);
        }

















    }
}
