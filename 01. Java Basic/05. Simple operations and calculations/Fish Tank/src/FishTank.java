import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int length=Integer.parseInt(scanner.nextLine());
        int width=Integer.parseInt(scanner.nextLine());
        int  height=Integer.parseInt(scanner.nextLine());
        double persent=Double.parseDouble(scanner.nextLine());

        double volume=length*width*height;
        double totalWater=volume*0.001;
        double persent1=persent*0.01;

        double needLWater=totalWater*(1-persent1);

        System.out.printf("%.2f", needLWater);




    }
}
