import java.util.Scanner;
import java.util.function.Predicate;

public class RhombusOfStars {
    public static void main(String[] args) {

        //прочете Input;
        int size = readInput();
        //Построи ромб
        String rhombusOfStars = buildRhombusOfStars(size);
        //Изпринти
        printOutput(rhombusOfStars);


    }


    private static String buildRhombusOfStars(int size) {

        return printMultipleRows(1, size, +1, size) +
                printMultipleRows(size - 1, 1, -1, size);
    }

    private static String printMultipleRows(int start, int end, int step, int size) {
        StringBuilder out = new StringBuilder();

        Predicate<Integer> loopCondition = iteration -> {
            if (step > 0) {
                return iteration <= end;
            }
            return iteration >= end;
        };

        for (int row = start; loopCondition.test(row); row += step) {
            out.append(printLine(size - row, row)).append(System.lineSeparator());
        }
        return out.toString();
    }

    private static String printLine(int spaces, int stars) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < spaces; i++) {
            out.append(" ");
        }
        for (int i = 0; i < stars; i++) {
            out.append("* ");
        }
        return out.toString();
    }

    private static int readInput() {
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }

    private static void printOutput(String rhombusOfStars) {
        System.out.println(rhombusOfStars);
    }
}
