package PizzaCalories;

import PizzaCalories.Dough;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfTopping) {
        this.setName(name);
        this.setToppings(numberOfTopping);
    }


    private void setName(String name) {
        if (name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("PizzaCalories.Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }


    private void setToppings(int count) {
        if (count >= 0 && count <= 10) {
            this.toppings = new ArrayList<>(count);
        } else {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        return this.dough.calculateCalories() + this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }
}
