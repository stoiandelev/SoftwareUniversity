import java.util.Scanner;

public class FaceOfCircle {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter circle radius. r=");

        double r=Double.parseDouble(scanner.nextLine());
        System.out.println("Area = " + Math.PI*r*r);
        //Math.Pi Вградена в Java константа за П.
        System.out.println("Perimeter = " + 2*Math.PI*r);

    }
}
