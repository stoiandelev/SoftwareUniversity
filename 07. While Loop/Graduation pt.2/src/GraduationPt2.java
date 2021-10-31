import java.util.Scanner;

public class GraduationPt2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name=scanner.nextLine();

        int clas=1;
        double sum=0;
        int outSchool=0;
        boolean outSchoolFlag=false;

        while (clas<=12){
            double evaluation=Double.parseDouble(scanner.nextLine());
            if(evaluation<4){
                outSchool++;
                if (outSchool==2){
                    System.out.printf("%s has been excluded at %d grade",name,clas);
                    outSchoolFlag=true;
                    break;
                }
                continue;
            }


            sum+=evaluation;
            clas++;
        }
        if(!outSchoolFlag){
            double averageEvaluation=sum/12;

            System.out.printf("%s graduated. Average grade: %.2f",name,averageEvaluation);
        }








    }
}
