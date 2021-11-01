import java.util.Scanner;

public class MountainRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double recordInSecond=Double.parseDouble(scanner.nextLine());
        double matters=Double.parseDouble(scanner.nextLine());
        double timeForOneMeter=Double.parseDouble(scanner.nextLine());

        double totalMeter=matters*timeForOneMeter;
        double minusMeter=Math.floor(matters/50)*30;

        double totalTime=totalMeter+minusMeter;

        if(recordInSecond<=totalTime){
            System.out.printf("No! He was %.2f seconds slower.",(totalTime-recordInSecond));
        }else{
           System.out.printf("Yes! The new record is %.2f seconds.",(totalTime));
        }















    }
}
