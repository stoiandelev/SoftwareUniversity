import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {

        String path = "/Users/stoiandelev/Desktop/LAB/input.txt";
        //чети от файла който се намира на този път
        try {
            FileInputStream inputStream = new FileInputStream(path);
            Scanner scanner = new Scanner(inputStream);

            int nextByte = inputStream.read();
            while (nextByte != -1) {
                System.out.print(Integer.toBinaryString(nextByte) + " ");
                nextByte = inputStream.read();
            }

        } catch (IOException name) {
            System.out.println(name.getMessage());
        }

    }
}
