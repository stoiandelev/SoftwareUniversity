package restaurant.core;

import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.InGarden;
import restaurant.entities.tables.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.BeverageRepository;
import restaurant.repositories.interfaces.HealthFoodRepository;
import restaurant.repositories.interfaces.TableRepository;

import java.util.LinkedHashMap;
import java.util.Map;

import static restaurant.common.ExceptionMessages.*;
import static restaurant.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;

    //Инициализираме ги
    private double totalMoney;
    private HealthyFood healthyFood;
    private Beverages beverages;
    private Table table;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository,
                          BeverageRepository<Beverages> beverageRepository,
                          TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {

        if (type.equals("Salad")) {
            healthyFood = new Salad(name, price);
        } else if (type.equals("VeganBiscuits")) {
            healthyFood = new VeganBiscuits(name, price);
        }

        if (healthFoodRepository.foodByName(healthyFood.getName()) != null) {
            throw new IllegalArgumentException(String.format(FOOD_EXIST, name));
        }

        healthFoodRepository.add(healthyFood);
        return String.format(FOOD_ADDED, name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {

        if (type.equals("Fresh")) {
            beverages = new Fresh(name, counter, brand);
        } else if (type.equals("Smoothie")) {
            beverages = new Smoothie(name, counter, brand);
        }

        if (beverageRepository.beverageByName(beverages.getName(), beverages.getBrand()) != null) {
            throw new IllegalArgumentException(String.format(BEVERAGE_EXIST, name));
        }

        beverageRepository.add(beverages);
        return String.format(BEVERAGE_ADDED, type, brand);
    }

    @Override
    public String addTable(String type, int number, int size) {

        if (type.equals("Indoors")) {
            table = new Indoors(number, size);
        } else if (type.equals("InGarden")) {
            table = new InGarden(number, size);
        }

        if (tableRepository.byNumber(table.getTableNumber()) != null) {
            throw new IllegalArgumentException(String.format(TABLE_IS_ALREADY_ADDED, number));
        }

        tableRepository.add(table);
        return String.format(TABLE_ADDED, number);
    }

    @Override
    public String reserve(int numberOfPeople) {

        for (Table table : tableRepository.getAllEntities()) {
            if (!table.isReservedTable() && table.getSize() >= numberOfPeople) {
                table.reserve(numberOfPeople);
                return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
            }
        }
        return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {

        if (tableRepository.byNumber(tableNumber) == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        if (healthFoodRepository.foodByName(healthyFoodName) == null) {
            return String.format(NONE_EXISTENT_FOOD, healthyFoodName);
        }

        HealthyFood healthyFood = healthFoodRepository.foodByName(healthyFoodName);
        tableRepository.byNumber(tableNumber).orderHealthy(healthyFood);

        return String.format(FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {

        if (tableRepository.byNumber(tableNumber) == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        if (beverageRepository.beverageByName(name, brand) == null) {
            return String.format(NON_EXISTENT_DRINK, name, brand);
        }

        Beverages beverages = beverageRepository.beverageByName(name, brand);
        tableRepository.byNumber(tableNumber).orderBeverages(beverages);

        return String.format(BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {

        double bill = tableRepository.byNumber(tableNumber).bill();
        totalMoney += bill;
        tableRepository.byNumber(tableNumber).clear();

        return String.format(BILL, tableNumber, bill);
    }

    @Override
    public String totalMoney() {
        return String.format(TOTAL_MONEY, totalMoney);
    }
}