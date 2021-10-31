import java.util.Scanner;

public class OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hoursExam = Integer.parseInt(scanner.nextLine());
        int minuteExam = Integer.parseInt(scanner.nextLine());
        int hoursArrive = Integer.parseInt(scanner.nextLine());
        int minuteArrive = Integer.parseInt(scanner.nextLine());

        int examTimeMinute = hoursExam * 60 + minuteExam;
        int arriveTimeMinute = hoursArrive * 60 + minuteArrive;

        if (arriveTimeMinute > examTimeMinute) {
            System.out.println("Late");
            int lateMinute = arriveTimeMinute - examTimeMinute;
            if (lateMinute < 60) {
                System.out.printf("%d minutes after the start", lateMinute);
            } else {
                int hours = lateMinute / 60;
                int minute = lateMinute % 60;
                System.out.printf("%d:%02d hours after the start", hours, minute);
            }
        } else if (examTimeMinute == arriveTimeMinute || (examTimeMinute - arriveTimeMinute) <= 30) {
            System.out.println("On time");
            if (examTimeMinute - arriveTimeMinute <= 30 && arriveTimeMinute!=examTimeMinute) {
                System.out.printf("%d minutes before the start", examTimeMinute - arriveTimeMinute);
            }
        } else if (examTimeMinute - arriveTimeMinute > 30) {
            System.out.println("Early");

            int earlyMinute = examTimeMinute - arriveTimeMinute;
            if (earlyMinute < 60) {
                System.out.printf("%d minutes before the start", earlyMinute);
            } else {
                int hours = earlyMinute / 60;
                int minute = earlyMinute % 60;

                System.out.printf("%d:%02d hours before the start", hours, minute);
            }
        }


    }
}
