import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "/Users/stoiandelev/Desktop/LAB/input.txt";

        FileReader reader = new FileReader(path);

        Scanner scanner = new Scanner(reader);

        while (scanner.hasNext()) {
            if(scanner.hasNextInt()){
                System.out.println(scanner.nextInt());
            }
            scanner.next();
        }


    }
}
