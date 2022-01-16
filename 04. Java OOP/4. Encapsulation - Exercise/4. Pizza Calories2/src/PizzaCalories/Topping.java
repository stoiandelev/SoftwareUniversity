package PizzaCalories;

public class Topping {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }


    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":
                this.toppingType = toppingType;
                break;
            default:
                String massage = String.format("Cannot place %s on top of your pizza.", toppingType);
                throw new IllegalArgumentException(massage);
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 50) {
            this.weight = weight;
        } else {
            String massage = String.format("%s weight should be in the range [1..50].", this.toppingType);
            throw new IllegalArgumentException(massage);
        }
    }

    public double calculateCalories() {
        //(2 * weight) * toppingModificator
        double toppingTypeModificator = this.getToppingTypeModificator(this.toppingType);
        return (2 * this.weight) * toppingTypeModificator;
    }

    private double getToppingTypeModificator(String toppingType) {
        switch (toppingType) {
            case "Meat":
                return 1.2;
            case "Veggies":
                return 0.8;
            case "Cheese":
                return 1.1;
            case "Sauce":
                return 0.9;
            default:
                return 0;
        }
    }
}
