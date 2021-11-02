import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget=Double.parseDouble(scanner.nextLine());
        int studentsCount=Integer.parseInt(scanner.nextLine());
        double priceLight=Double.parseDouble(scanner.nextLine());
        double priceRobe=Double.parseDouble(scanner.nextLine());
        double priceBelt=Double.parseDouble(scanner.nextLine());

        double sumLight=Math.ceil(studentsCount+studentsCount*0.10)*priceLight;
        double sumRobe=studentsCount*priceRobe;
        double sumBelt=(studentsCount-studentsCount/6)*priceBelt;

        double totalSum=sumLight+sumRobe+sumBelt;

        if(totalSum<=budget){
            System.out.printf("The money is enough - it would cost %.2flv.",totalSum);
        }else{
            double needMoney=totalSum-budget;
            System.out.printf("Ivan Cho will need %.2flv more.",needMoney);
        }










    }
}
