package entities.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
@DiscriminatorValue( value = "car")
public class Car extends Vehicle{
    public static final String CAR_TYPE = "Car";

    public Car() {
        super(CAR_TYPE);
    }

}
