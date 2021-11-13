import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = "/Users/stoiandelev/Desktop/LAB/input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        Set<Character> separators = new HashSet<>(Arrays.asList(',', '.', '!', '?'));

        int nextByte = inputStream.read();
        //принтиране в нов файл
        PrintStream printStream = new PrintStream("out.tht");

        while (nextByte != -1) {
            char symbol = (char)(nextByte);
            if (!separators.contains(symbol)) {
                //принтиране в нов файл
                printStream.print(symbol);
            }


            nextByte = inputStream.read();

        }

    }
}
