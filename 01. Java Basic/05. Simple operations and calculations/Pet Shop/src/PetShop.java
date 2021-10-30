import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int numberOfDogInZoo=Integer.parseInt(scanner.nextLine());
        double zooDog=numberOfDogInZoo*2.50;
        int numberOfNeighbor=Integer.parseInt(scanner.nextLine());
        double neighborDog=numberOfNeighbor*4;


        double totalPrice=zooDog+neighborDog;

        System.out.println(totalPrice+" "+"lv.");



    }
}
