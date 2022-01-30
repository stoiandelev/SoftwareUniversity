package restaurant.entities.tables;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static restaurant.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {

    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    protected BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        this.setSize(size);
        this.pricePerPerson = pricePerPerson;
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
    }

    public void setSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    @Override
    public int getTableNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }


    @Override
    public int numberOfPeople() {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        return numberOfPeople;
    }


    @Override
    public double pricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public double allPeople() {
        return allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.setSize(numberOfPeople);
        this.allPeople = numberOfPeople * pricePerPerson;
        this.isReservedTable = true;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double bill = this.allPeople;
        bill += this.beverages.stream().mapToDouble(Beverages::getPrice).sum() +
                this.healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();

        return bill;
    }

    @Override
    public void clear() {
        this.beverages.clear();
        this.healthyFood.clear();
        this.numberOfPeople = 0;
        this.allPeople = 0;
        this.isReservedTable = false;
    }

    @Override
    public String tableInformation() {
        return String.format("Table - %d%n" +
                        "Size - %d%n" +
                        "Type - %s%n" +
                        "All price - %.2f",
                this.number,
                this.size,
                this.getClass().getSimpleName(),
                this.pricePerPerson).trim();
    }
}
