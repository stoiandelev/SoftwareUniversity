import java.io.File;
import java.nio.file.Path;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "C:\\Users\\I353529\\Documents\\SoftUni\\Exercises Resources";
        File folder = new File(path);

        int folderSize = 0;
        for (File file : folder.listFiles()) {
            folderSize += file.length();
        }

        System.out.println("Folder size: " + folderSize);

    }
}