package Input;

import java.util.Arrays;
import java.util.Scanner;

public class Reader {
    //за да е инстанцията винаги една и съща
    public static Scanner scanner = new Scanner(System.in);
    public static int[] readArray(String delimiter) {
        return Arrays.stream(scanner.nextLine().split(delimiter))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
