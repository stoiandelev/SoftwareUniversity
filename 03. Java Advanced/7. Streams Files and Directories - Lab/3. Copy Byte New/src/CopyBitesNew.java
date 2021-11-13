import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class CopyBitesNew {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = "/Users/stoiandelev/Desktop/LAB/input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int nextByte = inputStream.read();

        PrintStream printStream = new PrintStream("copy bytes out.txt");
        while (nextByte != -1) {
            if (nextByte == ' ') {
                printStream.print((char) nextByte);
            } else if (nextByte == 10) {
                printStream.println();
            } else {
                printStream.print(nextByte);
            }
            nextByte = inputStream.read();

        }

    }
}
