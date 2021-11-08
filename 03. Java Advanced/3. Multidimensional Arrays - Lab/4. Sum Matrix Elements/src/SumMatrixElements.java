import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] rowsAndCols=readArray(scanner.nextLine(),", ");

        int rows=rowsAndCols[0];
        int cols=rowsAndCols[1];

        int[][] matrix = readMatrix(rows, cols, scanner, ", ");

        int elementsSum = getElementsSum(matrix);

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(elementsSum);



    }
    private static int getClosestItemsSum(int row, int col, int[][] matrix, int wrongValue) {
        // Най - близките елементи в матрицата -> сумата
        int sum = 0;

        if (isInBounds(row, col + 1, matrix) && matrix[row][col + 1] != wrongValue) {
            sum += matrix[row][col + 1];
        }
        if (isInBounds(row, col - 1, matrix) && matrix[row][col - 1] != wrongValue) {
            sum += matrix[row][col - 1];
        }
        if (isInBounds(row + 1, col, matrix) && matrix[row + 1][col] != wrongValue) {
            sum += matrix[row + 1][col];
        }
        if (isInBounds(row - 1, col, matrix) && matrix[row - 1][col] != wrongValue) {
            sum += matrix[row - 1][col];
        }

        return sum;
    }

    public static boolean isInBounds(int row, int col, int[][] matrix) {
        //дали е в матрицата
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    public static boolean isOutOfBounds(int row, int col, int[][] matrix) {
        //дали не е в матрицата
        return !isInBounds(row, col, matrix);
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

    public static char[][] getMatricesIntersection(char[][] first, char[][] second) {
        char[][] out = new char[first.length][];

        for (int row = 0; row < first.length; row++) {
            out[row] = new char[first[row].length];
            for (int col = 0; col < first[row].length; col++) {
                out[row][col] = first[row][col] == second[row][col]
                        ? first[row][col] : '*';
            }
        }

        return out;
    }

    public static char[][] readMatrixChar(int rows, int cols, Scanner scanner) {
        //прочитане на матрица, която не Char
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int col = 0; col < tokens.length; col++) {
                matrix[row][col] = tokens[col].charAt(0);
            }
        }

        return matrix;
    }

    public static int getElementsSum(int[][] matrix) {
        //сумата на елементите в матрицата
        int sum = 0;

        for (int[] array : matrix) {
            for (int element : array) {
                sum += element;
            }
        }

        return sum;
    }

    public static int getElementsSumWithStream(int[][] matrix) {
        // взимане на елементите в матрижата със stream.
        return Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .sum();
    }

    public static List<int[]> findNumberOccurrences(int[][] matrix, int number) {
        List<int[]> out = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int current = matrix[row][col];
                if (current == number) {
                    out.add(new int[]{row, col});
                }
            }
        }

        return out;
    }

    public static boolean matricesAreEqual(int[][] first, int[][] second) {
        //дали матриците са равни
        if (first.length != second.length) {
            return false;
        }

        for (int row = 0; row < first.length; row++) {
            int[] firstArray = first[row];
            int[] secondArray = second[row];

            if (firstArray.length != secondArray.length) {
                return false;
            }

            for (int col = 0; col < firstArray.length; col++) {
                if (firstArray[col] != secondArray[col]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int[][] readMatrix(int rows, int cols, Scanner scanner, String pattern) {
        // прочитане на матрица
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner.nextLine(), pattern);
        }

        return matrix;
    }

    public static void printMatrix(char[][] matrix) {
        //принтиране на матрица от Char
        for (char[] arr : matrix) {
            for (char element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
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
    public static int[] readArray(String line, String pattern) {
        return Arrays.stream(line.split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }


}
