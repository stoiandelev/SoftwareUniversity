import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int day = Integer.parseInt(scanner.nextLine());
        String roomType = scanner.nextLine();
        String experience=scanner.nextLine();

        int night = day - 1;
        double price = 0;

        if (roomType.equals("room for one person")) {
            price = 18 * night;
        } else if (roomType.equals("apartment") && day < 10) {
            price = 25 * night * 0.7;
        } else if (roomType.equals("apartment") && day >= 11 && day <= 15) {
            price = 25 * night * 0.65;
        } else if (roomType.equals("apartment") && day > 15) {
            price = 25 * night * 0.50;
        } else if (roomType.equals("president apartment") && day < 10) {
            price = 35 * night * 0.9;
        } else if (roomType.equals("president apartment") && day >= 11 && day <= 15){
            price = 35 * night * 0.85;
        } else if(roomType.equals("president apartment")&& day > 15){
            price =35*night*0.80;
        }

        if(experience.equals("positive")){
            price+=0.25*price;
        }else if(experience.equals("negative")){
            price-=0.10*price;
        }

        System.out.printf("%.2f",price);

    }
}




