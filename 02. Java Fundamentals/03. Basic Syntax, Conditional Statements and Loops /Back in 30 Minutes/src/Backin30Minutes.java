import java.util.Scanner;

public class Backin30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours=Integer.parseInt(scanner.nextLine());
        int minutes=Integer.parseInt(scanner.nextLine());

        int minutes1=minutes+30;

        if(minutes1>=60){
            minutes1=minutes1-60;
            hours=hours+1;
        }
        if(hours>=24){
            hours-=24;
        }

        if(minutes1<10){
            System.out.println(hours+":"+"0"+minutes1);
        }else{
            System.out.println(hours + ":" + minutes1);
        }



    }
}
