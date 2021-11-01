import java.util.Scanner;

public class FitnessCenter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num=Integer.parseInt(scanner.nextLine());

        int countBack=0;
        int countChest=0;
        int countLegs=0;
        int countAbs=0;
        int totalTrainer=0;

        int countSheik=0;
        int countBar=0;


        for (int i = 1; i <=num ; i++) {
            String active=scanner.nextLine();

            if(active.equals("Back")){
                countBack++;
                totalTrainer++;
            }else if(active.equals("Chest")){
                countChest++;
                totalTrainer++;
            }else if(active.equals("Legs")) {
                countLegs++;
                totalTrainer++;
            }else if(active.equals("Abs")) {
                countAbs++;
                totalTrainer++;
            }else if(active.equals("Protein shake")) {
                countSheik++;
            }else if(active.equals("Protein bar")) {
                countBar++;
            }
        }

        double persent=1.0*totalTrainer/num*100;

        double totalPeopleSheik=countSheik+countBar;
        double persentSheik=totalPeopleSheik/num*100;



        System.out.printf("%d - back%n",countBack);
        System.out.printf("%d - chest%n",countChest);
        System.out.printf("%d - legs%n",countLegs);
        System.out.printf("%d - abs%n",countAbs);
        System.out.printf("%d - protein shake%n",countSheik);
        System.out.printf("%d - protein bar%n",countBar);
        System.out.printf("%.2f%% - work out%n",persent);
        System.out.printf("%.2f%% - protein",persentSheik);

















    }
}
