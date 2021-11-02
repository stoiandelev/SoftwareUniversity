import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGame=Integer.parseInt(scanner.nextLine());
        double headsetPrice=Double.parseDouble(scanner.nextLine());
        double mousePrice=Double.parseDouble(scanner.nextLine());
        double keyboardPrice=Double.parseDouble(scanner.nextLine());
        double displayPrice=Double.parseDouble(scanner.nextLine());


        int totalTrashedHeadset=lostGame/2;
        double sumHeadSet=totalTrashedHeadset*headsetPrice;

        int totalTrashedMouse=lostGame/3;
        double sumMouse=totalTrashedMouse*mousePrice;

        int totalTrashedKeyboard=lostGame/6;
        double sumKeyboard=totalTrashedKeyboard*keyboardPrice;

        int totalTrashedDisplay=lostGame/12;
        double sumDisplay=totalTrashedDisplay*displayPrice;

        double expenses=sumHeadSet+sumMouse+sumKeyboard+sumDisplay;

        System.out.printf("Rage expenses: %.2f lv.",expenses);




























    }
}
