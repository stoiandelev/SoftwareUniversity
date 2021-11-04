import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudent = Integer.parseInt(scanner.nextLine());
        List<Students> allStudent = new ArrayList<>();
        for (int i = 0; i < numberOfStudent; i++) {
            String text = scanner.nextLine();

            String[] splitText = text.split("\\s+");

            String firstName = splitText[0];
            String lastName = splitText[1];
            double grade = Double.parseDouble(splitText[2]);

            Students student = new Students(firstName, lastName, grade);
            allStudent.add(student);


        }
        allStudent.sort(Comparator.comparing(Students::getGrade).reversed());

        for (Students students : allStudent) {
            System.out.println(students);

        }

    }
}
