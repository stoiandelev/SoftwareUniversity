import java.util.Scanner;

public class GreaterNumber {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int num1=scanner.nextInt();
        int num2=scanner.nextInt();

        if(num1>num2){
            System.out.println("Greeter number ="+ num1);
        }else{
            System.out.println("Greeter number ="+ num2);
        }


    }
}
