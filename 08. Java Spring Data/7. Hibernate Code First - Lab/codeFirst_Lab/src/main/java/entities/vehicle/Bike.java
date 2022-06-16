package entities.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bikes")
@DiscriminatorValue( value = "bike")
public class Bike extends Vehicle{
    private static final String BIKE_TYPE = "Bike";

    public Bike() {
        super(BIKE_TYPE);
    }
}
