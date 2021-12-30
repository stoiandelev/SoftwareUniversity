package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    //•	type: String
    //•	capacity: int
    private List<Car> data;
    private String type;
    private int capacity;


    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    //•	Method add(Car car) – adds an entity to the data if there is an empty cell for the car.

    public void add(Car car) {
        if(this.data.size() < capacity) {
            this.data.add(car);
        }
    }

    //•	Method remove(String manufacturer, String model) –
    // removes the car by given manufacturer and model, if such exists, and returns boolean.
    public boolean remove(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }

    //    •	Method getLatestCar() – returns the latest car (by year) or null if have no cars.
    public Car getLatestCar() {
        Car result = null;

        for (Car car : data) {
            if(result == null || result.getYear() < car.getYear()){
                result = car;
            }
        }
        return result;
    }

    //•	Method getCar(String manufacturer, String model) –
    // returns the car with the given manufacturer and model or null if there is no such car.
    public  Car getCar(String manufacturer, String model){
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }
    //•	Getter getCount() – returns the number of cars.
    public int getCount(){
        return this.data.size();
    }

    //•	getStatistics() – returns a String in the following format:
    //o	"The cars are parked in {parking type}:
    //{Car1}
    public String getStatistics(){
        StringBuilder fill = new StringBuilder();
        String toAppend = String.format("The cars are parked in %s:", this.type);
        fill.append(toAppend).append(System.lineSeparator());
        for (Car car : this.data) {
            fill.append(car.toString()).append(System.lineSeparator());
        }
        return fill.toString().trim();
    }
}