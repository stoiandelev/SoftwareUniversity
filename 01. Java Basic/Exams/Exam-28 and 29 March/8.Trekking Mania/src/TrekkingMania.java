import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numGroup=Integer.parseInt(scanner.nextLine());
        int allPeople=0;

        int musala=0;
        int monblan=0;
        int kilimanjaro=0;
        int k2=0;
        int everest=0;



        for (int i = 1; i <=numGroup ; i++) {
            int people=Integer.parseInt(scanner.nextLine());
            if(people<=5){
                musala+=people;
                allPeople+=people;

            }else if(people<=12){
                monblan+=people;
                allPeople+=people;

            }else if(people<=25){
                kilimanjaro+=people;
                allPeople+=people;

            }else if(people<=40){
                k2+=people;
                allPeople+=people;
            }else{
                everest+=people;
                allPeople+=people;
            }

        }
        double percentMasala=1.0*musala/allPeople*100;
        System.out.printf("%.2f%%%n",percentMasala);

        double percentMonblan=1.0*monblan/allPeople*100;
        System.out.printf("%.2f%%%n",percentMonblan);

        double percentKilimandaro=1.0*kilimanjaro/allPeople*100;
        System.out.printf("%.2f%%%n",percentKilimandaro);

        double percentk2=1.0*k2/allPeople*100;
        System.out.printf("%.2f%%%n",percentk2);

        double percenteverest=1.0*everest/allPeople*100;
        System.out.printf("%.2f%%%n",percenteverest);




























    }
}
