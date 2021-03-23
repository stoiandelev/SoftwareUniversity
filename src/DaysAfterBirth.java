import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class DaysAfterBirth {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String bDay = scan.nextLine();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthDay = LocalDate.parse(bDay,dateFormat).plusDays(999);
        System.out.println(dateFormat.format(birthDay));
    }
}