import java.util.Scanner;

public class VacationBookList {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int bookPage=Integer.parseInt(scanner.nextLine());
        int pageToHour=Integer.parseInt(scanner.nextLine());
        int day=Integer.parseInt(scanner.nextLine());

        int readAllBook=bookPage/pageToHour;
        int hourToDay=readAllBook/day;

        System.out.println(hourToDay);

    }
}
