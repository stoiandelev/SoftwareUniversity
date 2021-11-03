import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSumofRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countNumber=Integer.parseInt(scanner.nextLine());
        BigDecimal sum=new BigDecimal(0);

        for (int i = 0; i <countNumber ; i++) {
            String numberFromUser=scanner.nextLine();
            BigDecimal number=new BigDecimal(numberFromUser);
            sum=sum.add(number);

        }
        System.out.println(sum);




    }
}
