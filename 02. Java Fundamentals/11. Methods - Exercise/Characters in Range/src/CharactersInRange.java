import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char char1=scanner.next().charAt(0);
        char char2=scanner.next().charAt(0);

        charachterInRange(char1,char2);

    }

    private static void charachterInRange(char char1, char char2) {
        int firstChar=(int) char1;
        int secondChar=(int) char2;

        if(char1>char2){
            for (int i = secondChar+1; i <firstChar ; i++) {
                System.out.print((char) i+ " ");
            }
        }

        for (int i = firstChar+1; i <secondChar ; i++) {
            System.out.print((char) i+ " ");
        }
    }


}
