import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/stoiandelev/Desktop/LAB/input.txt";

        Path path = Path.of(fileName);

        List<String> lines = Files.readAllLines(path);

        for (int i = 0; i < lines.size(); i++) {
            if ((i + 1) % 3 == 0) {
                System.out.println(lines.get(i));
            }
        }


    }
}
