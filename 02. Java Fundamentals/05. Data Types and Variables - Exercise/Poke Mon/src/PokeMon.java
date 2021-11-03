import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pokePowerN = Integer.parseInt(scanner.nextLine());
        int distanceM = Integer.parseInt(scanner.nextLine());
        int exhaustionFactorY = Integer.parseInt(scanner.nextLine());

        int pokedTarget = 0;
        double half = pokePowerN / 2.0;

        while (pokePowerN >= distanceM) {
            pokedTarget++;
            pokePowerN -= distanceM;

            if (half == pokePowerN) {
                if (exhaustionFactorY > 0) {
                    pokePowerN /= exhaustionFactorY;
                }
            }
        }
        System.out.println(pokePowerN);
        System.out.println(pokedTarget);

    }
}
