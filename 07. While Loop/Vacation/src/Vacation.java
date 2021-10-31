import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double needMoney=Double.parseDouble(scanner.nextLine());
        double haveMoney=Double.parseDouble(scanner.nextLine());

        int countSpend=0;
        int countAllDays=0;

        while (needMoney>haveMoney){
            String action=scanner.nextLine();
            double actionMoney=Double.parseDouble(scanner.nextLine());
            countAllDays++;

            if(action.equals("spend")){
                countSpend++;
                haveMoney-=actionMoney;
                if(haveMoney<0){
                    haveMoney=0;
                }
                if(countSpend==5){
                    System.out.println("You can't save the money.");
                    System.out.println(countAllDays);
                    break;
                }
            }else if(action.equals("save")){
                countSpend=0;
                haveMoney+=actionMoney;
            }
        }

        if(needMoney<=haveMoney){
            System.out.printf("You saved the money for %d days.",countAllDays);
        }















    }
}
