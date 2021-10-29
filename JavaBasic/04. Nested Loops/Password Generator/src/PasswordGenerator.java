import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        int l=Integer.parseInt(scanner.nextLine());

        for (int first = 1; first <=n ; first++) {
            for (int second = 1; second <=n ; second++) {
                for (char third = 'a'; third <'a'+l ; third++) {
                    for (char fourth = 'a'; fourth <'a'+l ; fourth++) {
                        for (int five = 1; five <=n ; five++) {
                            if(five>first&&five>second){
                                System.out.printf("%d%d%c%c%d ",first,second,third,fourth,five);
                            }
                        }
                    }
                }
            }
        }










    }
}
