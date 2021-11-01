import java.util.Scanner;

public class EasterBake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int kozunak = Integer.parseInt(scanner.nextLine());
        int needSugar = 0;
        int needBrashno = 0;

        int maxSugar = Integer.MIN_VALUE;
        int maxBrashno = Integer.MIN_VALUE;


        for (int i = 1; i <= kozunak; i++) {
            int sugar = Integer.parseInt(scanner.nextLine());
            int brashno = Integer.parseInt(scanner.nextLine());
            if (sugar > maxSugar) {
                maxSugar = sugar;
            }
            if (brashno > maxBrashno) {
                maxBrashno = brashno;
            }

            needSugar += sugar;
            needBrashno += brashno;

        }
            double packageSugar = (1.0 * needSugar) / 950;
            packageSugar = Math.ceil(packageSugar);

            double packageBrashno = (1.0 * needBrashno) / 750;
            packageBrashno = Math.ceil(packageBrashno);


        System.out.printf("Sugar: %.0f%n",packageSugar);
        System.out.printf("Flour: %.0f%n",packageBrashno);
        System.out.printf("Max used flour is %d grams, max used sugar is %d grams.",maxBrashno,maxSugar);








    }
}
