import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimension[0];
        int cols = dimension[0];

        char matrix[][] = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }

        char color = scanner.nextLine().charAt(0);

        dimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int startRow = dimension[0];
        int startCow = dimension[1];

        char oldColor = matrix[startRow][startCow];

        colorPlane(matrix, startRow, startCow, color, oldColor);

        printMatrix(matrix);
    }

    private static void colorPlane(char[][] matrix, int row, int col, char color, char oldColor) {
        //проверките за спиране/края
        if (outOfBounds(matrix, row, col)) {
            return;
        }

        if (matrix[row][col] != oldColor) {
            return;
        }

        //действието
        matrix[row][col] = color;

        //движението/Update на стойностите

        colorPlane(matrix, row + 1, col, color, oldColor);
        colorPlane(matrix, row - 1, col, color, oldColor);
        colorPlane(matrix, row, col + 1, color, oldColor);
        colorPlane(matrix, row, col - 1, color, oldColor);

    }

    private static boolean outOfBounds(char[][] matrix, int row, int col) {
        return row >= matrix.length || row < 0 || col >= matrix[row].length || col < 0;
    }


    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char element : arr) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}
