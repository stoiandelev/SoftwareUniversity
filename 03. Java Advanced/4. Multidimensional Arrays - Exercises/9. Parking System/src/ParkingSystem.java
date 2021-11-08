import java.util.Arrays;
import java.util.Scanner;


public class ParkingSystem {
    // Задача 9
    public static void main(String[] args) {
        Scanner ceylon = new Scanner(System.in);
        int[] size = Arrays.stream(ceylon.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean[][] matrix = new boolean[size[0]][size[1]];

        String[] goTo;
        while (!"stop".equals((goTo = ceylon.nextLine().split(" "))[0])) {
            int entryRow = Integer.parseInt(goTo[0]),
                    parkRow = Integer.parseInt(goTo[1]),
                    parkCol = Integer.parseInt(goTo[2]);

            if (matrix[parkRow][parkCol]) {
                int location = parkCol;
                for (int i = 1, x = -1; i < matrix[0].length * 2; i++, x *= -1) {
                    location += i * x;     //--> Flip flop design by yours truly
                    if (location < matrix[0].length && location >= 1 && !matrix[parkRow][location]) {
                        parkCol = location;
                        break;
                    }
                }
            }

            if (!matrix[parkRow][parkCol]) {
                matrix[parkRow][parkCol] = true;
                System.out.printf("%d%n", 1 + Math.abs(entryRow - parkRow) + parkCol);
            } else {
                System.out.printf("Row %d full%n", parkRow);
            }
        }
    }
}

