package Vehicles;

public class Car extends Vehicle {
    private static final double AIR_CONDITIONAL_ADDITIONAL_CONSUMPTION
            = 0.9;

    public Car(double fuel, double consumption) {
        super(fuel, consumption
                + AIR_CONDITIONAL_ADDITIONAL_CONSUMPTION);
    }
}
