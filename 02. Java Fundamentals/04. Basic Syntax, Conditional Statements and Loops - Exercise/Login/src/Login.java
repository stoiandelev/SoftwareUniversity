import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String user=scanner.nextLine();
        StringBuilder passwordBuilder=new StringBuilder();

        for (int position = user.length()-1; position >=0 ; position--) {
            char currentSymbol=user.charAt(position);
            passwordBuilder.append(currentSymbol);
        }

        String password= passwordBuilder.toString();
        String command=scanner.nextLine();
        int count =0;

        while (!command.equals(password)){
            count++;
            if(count==4){
                System.out.printf("User %s blocked!", user);
                break;
            }
            System.out.println("Incorrect password. Try again.");
            command=scanner.nextLine();
        }
        if(command.equals(password)){
            System.out.printf("User %s logged in.", user);
        }


        
    }
}
