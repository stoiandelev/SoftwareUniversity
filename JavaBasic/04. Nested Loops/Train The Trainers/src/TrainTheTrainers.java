import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countJury=Integer.parseInt(scanner.nextLine());
        String command=scanner.nextLine();
        int countAllGrades=0;
        double sumAllGrades=0;

        while (!command.equals("Finish")){
            String presentation=command;
            double sumGradePerPresentation=0;
            for (int i = 1; i <=countJury ; i++) {
                double grade=Double.parseDouble(scanner.nextLine());
                countAllGrades++;
                sumGradePerPresentation+=grade;
                sumAllGrades+=grade;
            }
            double averageGrade=sumGradePerPresentation/countJury;
            System.out.printf("%s - %.2f.%n",presentation,averageGrade);
            command=scanner.nextLine();
        }
        double averageAll=sumAllGrades/countAllGrades;
        System.out.printf("Student's final assessment is %.2f.",averageAll);















    }
}
