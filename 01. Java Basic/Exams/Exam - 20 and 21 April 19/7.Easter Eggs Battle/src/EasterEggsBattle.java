import java.util.Scanner;

public class EasterEggsBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int eggsGame1=Integer.parseInt(scanner.nextLine());
        int eggsGame2=Integer.parseInt(scanner.nextLine());

        String command=scanner.nextLine();

        while (!command.equals("End of battle")){
            String winOrLose=command;
            if(command.equals("one")){
                eggsGame2=eggsGame2-1;
            }else if(command.equals("two")){
                    eggsGame1=eggsGame1-1;
                }
            if(eggsGame1==0||eggsGame2==0){
                break;
            }
            command=scanner.nextLine();
        }
        if(command.equals("End of battle")){
            System.out.printf("Player one has %d eggs left.%n",eggsGame1);
            System.out.printf("Player two has %d eggs left.",eggsGame2);
        }else if (eggsGame1==0){
            System.out.printf("Player one is out of eggs. Player two has %d eggs left.%n",eggsGame2);
        }else {
            System.out.printf("Player two is out of eggs. Player one has %d eggs left.",eggsGame1);
        }










    }
}
