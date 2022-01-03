import java.util.Scanner;

public class Selling {
    static int snakeRow = 0;
    static int snakeCol = 0;
    static int money = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //размера на полето
        int n = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[n][n];


        for (int i = 0; i < n; i++) {
            //прочитаме следваща ред
            String line = scanner.nextLine();
            //попълваме реда
            field[i] = line.toCharArray();
            //намираме къде е змията
            if (line.contains("S")) {
                snakeRow = i;
                snakeCol = line.indexOf("S");
            }

        }

        boolean isInField = true;
        boolean isHaveMoney = false;

        //четем докато условието е вярно или в в рамките на матрицата
        while (isInField) {
            String direction = scanner.nextLine();


            if (direction.equals("up")) {
                isInField = moveSnake(field, -1, 0);
            } else if (direction.equals("down")) {
                isInField = moveSnake(field, +1, 0);
            } else if (direction.equals("left")) {
                isInField = moveSnake(field, 0, -1);
            } else {
                isInField = moveSnake(field, 0, +1);
            }

            if(money>=50){
                isHaveMoney=true;
                break;
            }


        }


        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news, you are out of the bakery.");
        }

        System.out.println("Money: " + money);
        System.out.println(getFieldString(field));


    }

    private static String getFieldString(char[][] field) {
        StringBuilder builder = new StringBuilder();
        for (char[] row : field) {
            for (char element : row) {
                builder.append(element);
            }
            //след отпечаване на елементите на реда да минев на нов ред
            builder.append(System.lineSeparator());

        }
        return builder.toString();
    }

    private static boolean moveSnake(char[][] field, int rowAddition, int colAddition) {

        //oпашката на змията
        field[snakeRow][snakeCol] = '-';

        boolean isInBounds = inBounds(field, snakeRow + rowAddition, snakeCol + colAddition);

        if (isInBounds) {



            //проверяваме дали е храна, щом е нагоре е -1;
            if (Character.isDigit(field[snakeRow + rowAddition][snakeCol + colAddition])) {
                //eats food
                money +=Integer.parseInt(String.valueOf(field[snakeRow + rowAddition][snakeCol + colAddition])) ;
            } else if (field[snakeRow + rowAddition][snakeCol + colAddition] == 'O') {
                //изчезва бункера на който стъпвам;
                field[snakeRow + rowAddition][snakeCol + colAddition] = '-';

                for (int r = 0; r < field.length; r++) {
                    for (int c = 0; c < field[r].length; c++) {
                        if (field[r][c] == 'O') {
                            snakeRow = r;
                            snakeCol = c;
                            //махаме бункера
                            field[snakeRow][snakeCol] = 'S';
                            //за да се махнем от метода, да не продължаваме надолу
                            return true;
                        }
                    }
                }
            }

            //сменяме позиция на звимията
            snakeRow += rowAddition;
            snakeCol += colAddition;
            field[snakeRow][snakeCol] = 'S';
        }

        return isInBounds;

    }

    private static boolean inBounds(char[][] field, int row, int col) {
        return row >= 0 && row < field.length && col >= 0 && col < field[row].length;

    }
}

