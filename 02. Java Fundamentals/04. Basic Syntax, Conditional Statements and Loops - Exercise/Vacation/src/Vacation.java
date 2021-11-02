import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfGroup=Integer.parseInt(scanner.nextLine());
        String peopleKind = scanner.nextLine();
        String day = scanner.nextLine();


        double price = 0;

        switch (peopleKind) {
            case "Students":
                if (day.equals("Friday")) {
                    price = 8.45*numOfGroup;
                } else if (day.equals("Saturday")) {
                    price = 9.80*numOfGroup;
                } else if (day.equals("Sunday")) {
                    price = 10.46*numOfGroup;
                }
                if(numOfGroup>=30){
                    price=price*0.85;
                }
                    System.out.printf("Total price: %.2f",price);
                break;

            case "Business":
                if (day.equals("Friday")) {
                    price = 10.90*numOfGroup;
                } else if (day.equals("Saturday")) {
                    price = 15.60*numOfGroup;
                } else if (day.equals("Sunday")) {
                    price = 16*numOfGroup;
                }

                if(numOfGroup>=100&&day.equals("Friday")){
                    price-=10*10.90;
                }else if(numOfGroup>=100&&day.equals("Saturday")){
                    price-=10*15.60;
                }else if(numOfGroup>=100&&day.equals("Sunday")) {
                    price -= 10 * 16;
                }

                System.out.printf("Total price: %.2f",price);
                break;

            case "Regular":
                if (day.equals("Friday")) {
                    price = 15*numOfGroup;
                } else if (day.equals("Saturday")) {
                    price = 20*numOfGroup;
                } else if (day.equals("Sunday")) {
                    price = 22.50*numOfGroup;
                }

                if(numOfGroup>=10&&numOfGroup<=20){
                    price=price*0.95;
                }
                System.out.printf("Total price: %.2f",price);
                break;

        }




    }
}
