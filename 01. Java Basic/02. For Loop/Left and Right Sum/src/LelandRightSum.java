import java.util.Scanner;

public class LelandRightSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        int sumLeft=0;
        int sumRight=0;


        for (int i = 0; i <n ; i++) {
            int leftNumber = Integer.parseInt(scanner.nextLine());
            sumLeft+=leftNumber;
        }
        for (int i = 0; i <n ; i++) {
            int rightNumber = Integer.parseInt(scanner.nextLine());
            sumRight+=rightNumber;
        }
        

        if(sumLeft==sumRight){
            System.out.println("Yes, sum = " +sumRight);
        }else{
            System.out.println("No, diff = " +Math.abs(sumLeft-sumRight));
        }












    }
}
