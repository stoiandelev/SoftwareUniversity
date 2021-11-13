import java.io.File;
import java.util.ArrayDeque;
import java.util.Scanner;

public class NestedFolders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        File file = new File("/Users/stoiandelev/Desktop/LAB/Files-and-Streams");

        ArrayDeque<File> files = new ArrayDeque<>();

        files.offer(file);

        while (!files.isEmpty()) {
            File innerFile = files.poll();
            System.out.println(innerFile.getName());
            for (File f : innerFile.listFiles()) {
                if (f.isDirectory()) {
                    files.offer(f);
                } else {
                    System.out.println(f.getName());
                }
            }

        }


    }
}
