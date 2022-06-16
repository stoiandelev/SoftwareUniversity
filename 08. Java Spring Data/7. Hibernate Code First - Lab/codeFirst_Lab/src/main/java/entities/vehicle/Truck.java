package entities.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "trucks")
@DiscriminatorValue( value = "truck")
public class Truck extends TransportationVehicle{
    public static final String TRUCK_TYPE = "Truck";

    public Truck(int loadCapacity) {
        super(TRUCK_TYPE, loadCapacity);
    }

    public Truck() {}
}
