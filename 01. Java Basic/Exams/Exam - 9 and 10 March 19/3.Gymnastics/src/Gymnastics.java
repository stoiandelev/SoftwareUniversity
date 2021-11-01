import java.util.Scanner;

public class Gymnastics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String country=scanner.nextLine();
        String device=scanner.nextLine();
        double evaluation=0;
        double evaluation1=0;
        double sumEvaluation=0;


        switch (country){
            case "Russia":
                if(device.equals("ribbon")){
                    evaluation=9.100;
                    evaluation1=9.400;
                    sumEvaluation=evaluation+evaluation1;
                }else if(device.equals("hoop")){
                    evaluation=9.300;
                    evaluation1=9.800;
                    sumEvaluation=evaluation+evaluation1;
                }else if(device.equals("rope")){
                    evaluation=9.600;
                    evaluation1=9.000;
                    sumEvaluation=evaluation+evaluation1;
                }break;
            case "Bulgaria":
                if(device.equals("ribbon")){
                    evaluation=9.600;
                    evaluation1=9.400;
                    sumEvaluation=evaluation+evaluation1;
                }else if(device.equals("hoop")){
                    evaluation=9.550;
                    evaluation1=9.750;
                    sumEvaluation=evaluation+evaluation1;
                }else if(device.equals("rope")){
                    evaluation=9.500;
                    evaluation1=9.400;
                    sumEvaluation=evaluation+evaluation1;
                }break;
            case "Italy":
                if(device.equals("ribbon")){
                    evaluation=9.200;
                    evaluation1=9.500;
                    sumEvaluation=evaluation+evaluation1;
                }else if(device.equals("hoop")){
                    evaluation=9.450;
                    evaluation1=9.350;
                    sumEvaluation=evaluation+evaluation1;
                }else if(device.equals("rope")){
                    evaluation=9.700;
                    evaluation1=9.150;
                    sumEvaluation=evaluation+evaluation1;
                }break;

        }
        double totalCount=20-sumEvaluation;
        double needPercent=(totalCount/ 20) * 100;

        System.out.printf("The team of %s get %.3f on %s.%n",country,sumEvaluation,device);
        System.out.printf("%.2f%%",needPercent);

























    }
}
