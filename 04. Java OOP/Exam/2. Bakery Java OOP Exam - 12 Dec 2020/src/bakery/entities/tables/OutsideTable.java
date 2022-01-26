package bakery.entities.tables;

public class OutsideTable extends BaseTable {
    private static final double DEFAULT_PRICE_PER_PERSON = 3.50;

    public OutsideTable(int tableNumber, int capacity) {
        super(tableNumber, capacity, DEFAULT_PRICE_PER_PERSON);
    }
}
