import java.util.Scanner;

public class EasterShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int haveEggs=Integer.parseInt(scanner.nextLine());
        String command=scanner.nextLine();

        int countEggs=0;
        int salesEggs=0;


        while (!command.equals("Close")){
            String eggs=command;

            if(command.equals("Fill")){
                countEggs=Integer.parseInt(scanner.nextLine());
                haveEggs+=countEggs;
            }else if(command.equals("Buy")){
                countEggs=Integer.parseInt(scanner.nextLine());
                if(countEggs>haveEggs){
                    System.out.println("Not enough eggs in store!");
                    System.out.printf("You can buy only %d.",haveEggs);
                    break;
                }
                haveEggs-=countEggs;
                salesEggs+=countEggs;

            }

            command=scanner.nextLine();
        }
        if(command.equals("Close")){
            System.out.printf("Store is closed!%n");
            System.out.printf("%d eggs sold.",salesEggs);
        }



















    }
}
