import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] pathSplit = text.split("\\\\");
        String lastArray = pathSplit[pathSplit.length - 1];

        String[] spitLastArray = lastArray.split("\\.");

        String fileName = spitLastArray[0];
        String extension = spitLastArray[1];

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extension);


    }
}
