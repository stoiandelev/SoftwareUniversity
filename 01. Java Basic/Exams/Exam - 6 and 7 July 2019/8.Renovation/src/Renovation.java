import java.util.Scanner;

public class Renovation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int height=Integer.parseInt(scanner.nextLine());
        int width=Integer.parseInt(scanner.nextLine());
        int percent=Integer.parseInt(scanner.nextLine());
        String command=scanner.nextLine();

        int walls=(height*width)*4;
        walls=(int) Math.ceil(walls-(walls/100.0*percent));


        while (!command.equals("Tired!")){
            walls-=Integer.parseInt(command);

            if (walls <= 0) {
                break;
            }
            command=scanner.nextLine();
        }
        if(walls>0){
            System.out.printf("%d quadratic m left.",walls);
        }else if(walls==0){
            System.out.println("All walls are painted! Great job, Pesho!");
        }else{
            System.out.printf("All walls are painted and you have %d l paint left!",Math.abs(walls));
        }























    }
}
