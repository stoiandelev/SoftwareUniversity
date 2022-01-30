package restaurant.entities.drinks;

public class Smoothie extends BaseBeverage {

    private static final double SMOOTHIES_PRICE = 4.50;


    public Smoothie(String name, int counter, String brand) {
        super(name, counter, SMOOTHIES_PRICE, brand);
    }
}
