import java.util.Scanner;

public class LowerorUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char char1=scanner.next().charAt(0);

        if(char1>=97 && char1<=122){
            System.out.println("lower-case");
        }else if (char1>=65 &&char1<=90){
            System.out.println("upper-case");
        }



    }
}
