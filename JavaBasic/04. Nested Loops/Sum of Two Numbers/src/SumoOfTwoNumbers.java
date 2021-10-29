import java.util.Scanner;

public class SumoOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startNumber = Integer.parseInt(scanner.nextLine());
        int endNumber = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());

        int counter = 0;
        boolean isFound = false;

        for (int i = startNumber; i <= endNumber; i++) {
            for (int j = startNumber; j <= endNumber; j++) {
                counter++;
                if (i + j == magicNumber) {
                    isFound = true;
                    System.out.printf("Combination N:%d (%d + %d = %d)", counter, i, j, magicNumber);
                    break;
                }
            }
            if(isFound){
                break;
            }

        }
        if(!isFound){
            System.out.printf("%d combinations - neither equals %d",counter,magicNumber);
        }







    }


}

