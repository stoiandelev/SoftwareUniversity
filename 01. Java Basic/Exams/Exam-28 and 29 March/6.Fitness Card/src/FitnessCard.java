import java.util.Scanner;

public class FitnessCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum=Double.parseDouble(scanner.nextLine());
        String gender=scanner.nextLine();
        int age=Integer.parseInt(scanner.nextLine());
        String sport=scanner.nextLine();
        double price=0;

        switch (gender){
            case"m":
                if(sport.equals("Gym")){
                    price =42;
                    break;
                }else if(sport.equals("Boxing")){
                    price=41;
                    break;
                }else if (sport.equals("Yoga")){
                    price=45;
                    break;
                }else if (sport.equals("Zumba")){
                    price=34;
                    break;
                }else if (sport.equals("Dances")){
                    price=51;
                    break;
                }else if (sport.equals("Pilates")){
                    price=39;
                    break;
                }

            case"f":
                if(sport.equals("Gym")){
                    price =35;
                    break;
                }else if(sport.equals("Boxing")){
                    price=37;
                    break;
                }else if (sport.equals("Yoga")){
                    price=42;
                    break;
                }else if (sport.equals("Zumba")){
                    price=31;
                    break;
                }else if (sport.equals("Dances")){
                    price=53;
                    break;
                }else if (sport.equals("Pilates")){
                    price=37;
                     break;
                }


        }

        if(age<=19){
            price=price-(price*0.20);


        }



        if(sum>=price){
            System.out.printf("You purchased a 1 month pass for %s.",sport);
        }else{
            price=price-sum;
            System.out.printf("You don't have enough money! You need $%.2f more.",price);
        }








    }

}

