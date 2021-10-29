import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        double bonusPoint = 0;

        if (number % 2 == 0) {
            bonusPoint = 1;
        } else if (number % 5 == 0) {
            bonusPoint = 2;
        }

        if (number <= 100) {
            bonusPoint += 5;
        } else if (number > 100 && number < 1000) {
            bonusPoint += number * 0.2;
        } else if (number > 1000) {
            bonusPoint +=number*0.1;
        }
        System.out.println(bonusPoint);
        System.out.println(number+bonusPoint);
    }

}
