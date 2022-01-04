import java.util.Arrays;
import java.util.Scanner;

public class Python {
    private static int pythonRow =-1;
    private static int pythonCol=-1;
    private static String[][] field;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int foodCount = 0;
        int snakeSize = 1;

        int field = Integer.parseInt(sc.nextLine());

        String[] commands = Arrays.stream(sc.nextLine().split(", ")).toArray(String[]::new);

        Python.field = new String[field][field];

        for (int i = 0; i < field; i++) {
            Python.field[i] = sc.nextLine().split("\\s+");
            foodCount += Arrays.stream(Python.field[i]).filter(element -> element.equals("f")).toArray().length;
            if (pythonRow == -1) {
                int[] positions = getPythonPosition(i, Python.field[i]);
                if (positions != null) {
                    pythonRow = positions[0];
                    pythonCol = positions[1];
                    Python.field[pythonRow][pythonCol] = "*";
                }
            }
        }

        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];
            moveSnake(currentCommand);

            if (foodFound()) {
                snakeSize++;
                foodCount--;
            }
            if (foodCount == 0) {
                System.out.printf("You win! Final python length is %s%n", snakeSize);
                return;
            }

            if (killed()) {
                System.out.printf("You lose! Killed by an enemy!%n");
                return;
            }
        }

        System.out.printf("You lose! There is still %s food to be eaten.", foodCount);
    }

    private static void moveSnake(String direction) {
        if (direction.equals("up")) {
            pythonRow--;
        } else if (direction.equals("down")) {
            pythonRow++;
        } else if (direction.equals("left")) {
            pythonCol--;
        } else if (direction.equals("right")) {
            pythonCol++;
        }

        changePythonPosition();
    }

    private static void changePythonPosition() {
        if (pythonRow < 0) {
            pythonRow = field.length - 1;
        }
        if (pythonRow > field.length) {
            pythonRow = 0;
        }
        if (pythonCol < 0) {
            pythonCol = field[0].length - 1;
        }
        if (pythonCol > field[0].length - 1) {
            pythonCol = 0;
        }
    }

    private static int[] getPythonPosition(int row, String[] col) {
        for (int i = 0; i < col.length; i++) {
            if (col[i].equals("s")) {
                return new int[]{row, i};
            }
        }
        return null;
    }

    private static boolean killed() {
        return field[pythonRow][pythonCol].equals("e");
    }

    private static boolean foodFound() {
        if (field[pythonRow][pythonCol].equals("f")) {
            field[pythonRow][pythonCol] = "*";
            return true;
        }
        return false;
    }


}