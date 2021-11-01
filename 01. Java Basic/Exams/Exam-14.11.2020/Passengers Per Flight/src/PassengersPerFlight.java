import java.util.Scanner;

public class PassengersPerFlight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int avioCampany=Integer.parseInt(scanner.nextLine());

        int countFly=0;
        int countPassenger=0;

        double maxPassenger=Double.MIN_VALUE;
        String maxCompany="";


        for (int i = 1; i <=avioCampany ; i++) {
            String name=scanner.nextLine();

            String passenger=scanner.nextLine();

            while (!passenger.equals("Finish")){
                int currentpPassenger=Integer.parseInt(passenger);
                countFly++;
                countPassenger+=currentpPassenger;



                passenger=scanner.nextLine();
            }
            double averagePassenger=Math.floor(1.0*countPassenger/countFly);

            if(averagePassenger>maxPassenger){
                maxPassenger=averagePassenger;
                maxCompany=name;
            }

            System.out.printf("%s: %.0f passengers.%n",name,averagePassenger);
            countFly=0;
            countPassenger=0;

        }


        System.out.printf("%s has most passengers per flight: %.0f",maxCompany,maxPassenger);





















    }
}
