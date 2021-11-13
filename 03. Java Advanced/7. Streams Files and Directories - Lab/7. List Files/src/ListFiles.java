import java.io.File;
import java.util.Scanner;

public class ListFiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        File file = new File("/Users/stoiandelev/Desktop/LAB/Files-and-Streams");

        File[] files = file.listFiles();

        for (File f : files) {
            if(!f.isDirectory()){
                System.out.printf("%s: [%d]%n",f.getName(),f.length());
            }

        }
    }

}
