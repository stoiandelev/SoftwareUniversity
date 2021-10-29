import java.util.Scanner;

public class SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command=scanner.nextLine();
        int sumPrime=0;
        int sumNonPrime=0;

        while (!command.equals("stop")){
            int number=Integer.parseInt(command);
            if(number<0){
                System.out.println("Number is negative.");
                command=scanner.nextLine();
                continue;
            }
            int count=0;
            for (int i = 1; i <=number ; i++) {
                if(number%i==0){
                    count++;
                }
            }
            if(count==2){
                sumPrime+=number;
            }else if(count>2){
                sumNonPrime+=number;
            }

            command=scanner.nextLine();

        }
        System.out.printf("Sum of all prime numbers is: %d%n",sumPrime);
        System.out.printf("Sum of all non prime numbers is: %d",sumNonPrime);















    }
}
