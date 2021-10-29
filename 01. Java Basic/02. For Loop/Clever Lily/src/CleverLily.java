import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age=Integer.parseInt(scanner.nextLine());
        double priceWashMachine=Double.parseDouble(scanner.nextLine());
        int priceToys=Integer.parseInt(scanner.nextLine());


        double toy = 0;
        double savedMoneyFromBirthDay = 0.0;

        double totalMoney;
        double secondMoney=0;
        double counter = 0;
        double priceFromToy;

        for (int i = 1; i <= age; i++)
        {
            if (i % 2 == 0)
            {
                savedMoneyFromBirthDay = savedMoneyFromBirthDay + 10;
                secondMoney = secondMoney + savedMoneyFromBirthDay;
                counter++;
            }
            else
                toy++;

        }
        priceFromToy = toy * priceToys;

        totalMoney = secondMoney + priceFromToy - counter;

        if(totalMoney >= priceWashMachine)
        {
            double leftSum=totalMoney-priceWashMachine;
            System.out.printf("Yes! "+"%.2f",leftSum);
        } else

            System.out.printf("No! "+"%.2f",Math.abs(priceWashMachine-totalMoney));
    }
}


























