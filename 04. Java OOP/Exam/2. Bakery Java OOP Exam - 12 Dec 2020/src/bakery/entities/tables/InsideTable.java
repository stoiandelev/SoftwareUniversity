package bakery.entities.tables;

public class InsideTable extends BaseTable {
    private static final double DEFAULT_PRICE_PER_PERSON = 2.50;

    public InsideTable(int tableNumber, int capacity) {
        super(tableNumber, capacity, DEFAULT_PRICE_PER_PERSON);
    }
}
