import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class SumLines {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\I353529\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";

        Files.readAllLines(Path.of(path)).stream()
                .map(String :: toCharArray)  //str -> str.toCharArray
                .forEach(charArray ->
                {
                    int sum = 0;
                    for (char symbol : charArray) {
                        sum += symbol;
                    }
                    System.out.println(sum);
                });



    }
}