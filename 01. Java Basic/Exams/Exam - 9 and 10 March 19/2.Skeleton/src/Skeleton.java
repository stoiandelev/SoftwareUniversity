import java.util.Scanner;

public class Skeleton {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minute=Integer.parseInt(scanner.nextLine());
        int second=Integer.parseInt(scanner.nextLine());
        double length=Double.parseDouble(scanner.nextLine());
        int secFor100Meter=Integer.parseInt(scanner.nextLine());

        int cotrolInSecond=minute*60+second;

        double timeDown=length/120;
        double totalTimeDowl=timeDown*2.5;

        double timePlayer=(length/100)*secFor100Meter-totalTimeDowl;


        if(timePlayer<=cotrolInSecond){
            System.out.println("Marin Bangiev won an Olympic quota!");
            System.out.printf("His time is %.3f.",timePlayer);
        }else{
            System.out.printf("No, Marin failed! He was %.3f second slower.",timePlayer-cotrolInSecond);
        }








    }
}
