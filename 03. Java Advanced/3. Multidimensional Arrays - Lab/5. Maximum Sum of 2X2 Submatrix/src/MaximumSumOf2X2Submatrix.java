import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] rowsAndCols=readArray(scanner.nextLine(),", ");

        int rows=rowsAndCols[0];
        int cols=rowsAndCols[1];

        int[][] matrix = readMatrix(rows, cols, scanner, ", ");

        int[][] maxSumSubMatrix = getMaxSumSubMatrix2By2(matrix);

        printMatrix(maxSumSubMatrix);
        System.out.println(getElementsSumWithStream(maxSumSubMatrix));


    }
    public static int[][] readMatrix(int rows, int cols, Scanner scanner, String pattern) {
        // прочитане на матрица
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner.nextLine(), pattern);
        }

        return matrix;
    }
    public static int[] readArray(String line, String pattern) {
        return Arrays.stream(line.split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    public static int[][] getMaxSumSubMatrix2By2(int[][] matrix) {
        //взимане на сумата на 2х2 матрици
        int maxSum = 0;

        int bestRow = 0;
        int bestCol = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum =
                        matrix[row][col] +
                                matrix[row][col + 1] +
                                matrix[row + 1][col] +
                                matrix[row + 1][col + 1];

                if (sum > maxSum) {
                    maxSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }

        return new int[][] {
                {matrix[bestRow][bestCol], matrix[bestRow][bestCol + 1]},
                {matrix[bestRow + 1][bestCol], matrix[bestRow + 1][bestCol + 1]}
        };
    }
    public static void printMatrix(int[][] matrix) {
        //принтиране на матрица от int
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public static int getElementsSumWithStream(int[][] matrix) {
        // взимане на елементите в матрижата със stream.
        return Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .sum();
    }
}
