import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] firstRow=scanner.nextLine().split(" ");
        String [] secondRow=scanner.nextLine().split(" ");

        for (String word2 : secondRow) {
            for (String word1 : firstRow) {
                if(word2.equals(word1)){
                    System.out.print(word2+ " ");
                    break;
                }
            }
        }




    }
}
