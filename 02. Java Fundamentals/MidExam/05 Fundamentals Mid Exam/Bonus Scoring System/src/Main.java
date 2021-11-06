import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfTheStudents = Integer.parseInt(scanner.nextLine());
        int countOfTheLectures = Integer.parseInt(scanner.nextLine());
        int initialBonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = Integer.MIN_VALUE;
        int maxAttended = Integer.MIN_VALUE;

        if (countOfTheLectures == 0) {
            System.out.printf("Max Bonus: 0.%n");
            System.out.println("The student has attended 0 lectures.");
        } else {


            for (int i = 1; i <= countOfTheStudents; i++) {

                int studentAttendances = Integer.parseInt(scanner.nextLine());

                double totalBonus = 1.0 * studentAttendances / countOfTheLectures * (5 + initialBonus);

                if (totalBonus > maxBonus) {
                    maxBonus = totalBonus;
                    maxAttended = studentAttendances;
                }


            }
            if (maxAttended == 0) {
                System.out.printf("Max Bonus: 0.%n");
                System.out.printf("The student has attended 0 lectures.");
            } else {
                System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonus));
                System.out.printf("The student has attended %d lectures.", maxAttended);
            }


        }


    }


}

