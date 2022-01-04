import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class Bee {
    static int snakeRow = 0, snakeCol = 0, pollinateFlowers = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            field[i] = line.toCharArray();

            if (line.contains("B")) {
                snakeRow = i;
                snakeCol = line.indexOf("B");
            }
        }

        boolean isInField = true;
        String direction = scanner.nextLine();

        while (isInField && !direction.equals("End")) {

                if (direction.equals("up")) {
                    isInField = moveSnake(field, -1, 0);
                } else if (direction.equals("down")) {
                    isInField = moveSnake(field, +1, 0);

                } else if (direction.equals("left")) {
                    isInField = moveSnake(field, 0, -1);
                } else {
                    isInField = moveSnake(field, 0, +1);
                }

                if(!isInField){
                    System.out.println("The bee got lost!");
                    if (pollinateFlowers >= 5) {
                        System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinateFlowers);
                    } else {
                        System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinateFlowers);
                    }
                    System.out.println(getFieldString(field));
                    return;
                }

                direction = scanner.nextLine();

        }


        if (pollinateFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinateFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinateFlowers);
        }


        System.out.println(getFieldString(field));


    }

    private static String getFieldString(char[][] field) {
        StringBuilder out = new StringBuilder();
        for (char[] row : field) {
            for (char element : row) {
                out.append(element);
            }
            out.append(System.lineSeparator());
        }

        return out.toString();
    }


    public static boolean moveSnake(char[][] field, int rowAddition, int colAddition) {
        field[snakeRow][snakeCol] = '.';
        boolean isInBounds = inBounds(field, snakeRow + rowAddition, snakeCol + colAddition);
        if (isInBounds) {
            if (field[snakeRow + rowAddition][snakeCol + colAddition] == 'f') {
                pollinateFlowers += 1;
            } else if (field[snakeRow + rowAddition][snakeCol + colAddition] == 'O') {
                field[snakeRow + rowAddition][snakeCol + colAddition] = '.';

                snakeRow += rowAddition;
                snakeCol += colAddition;
                if (field[snakeRow + rowAddition][snakeCol + colAddition] == 'f') {
                    pollinateFlowers += 1;
                }


//                for (int r = 0; r < field.length; r++) {
//                    for (int c = 0; c < field[r].length; c++) {
//                        if (field[r][c] == 'O') {
//                            snakeRow = r;
//                            snakeCol = c;
//                            field[snakeRow][snakeCol] = 'O';
//                            return true;
//                        }
//                    }
//                }
            }

            snakeRow += rowAddition;
            snakeCol += colAddition;
            field[snakeRow][snakeCol] = 'B';

        }
        return isInBounds;
    }

    private static boolean inBounds(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }
}