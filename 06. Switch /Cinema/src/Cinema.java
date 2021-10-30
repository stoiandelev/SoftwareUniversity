import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String projection=scanner.nextLine();
        int row=Integer.parseInt(scanner.nextLine());
        int columns=Integer.parseInt(scanner.nextLine());

        double income=0;

        if(projection.equals("Premiere")){
            income=row*columns*12;
        }else if(projection.equals("Normal")){
            income=row*columns*7.50;
        }else{
            income=row*columns*5.00;
        }
        System.out.printf("%.2f",income);





















    }
}
