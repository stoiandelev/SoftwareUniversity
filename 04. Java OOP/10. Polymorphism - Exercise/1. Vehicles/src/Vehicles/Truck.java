package Vehicles;

public class Truck extends Vehicle {
    private static final double AIR_CONDITIONAL_ADDITIONAL_CONSUMPTION
            = 1.6;

    public Truck(double fuel, double consumption) {
        super(fuel, consumption
                + AIR_CONDITIONAL_ADDITIONAL_CONSUMPTION);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}
