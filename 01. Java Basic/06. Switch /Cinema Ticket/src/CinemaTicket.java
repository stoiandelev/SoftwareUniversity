import java.util.Scanner;

public class CinemaTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dayOfWeek = scanner.nextLine();


        switch (dayOfWeek){
            case "Monday":
            case "Tuesday":
                System.out.println("12");
                break;
            case "Wednesday":
            case "Thursday":
                System.out.println("14");
                break;
            case "Friday":
                System.out.println("12");
                break;
            default:
                System.out.println("16");
                break;

        }








    }

}