import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InstockTest {

    private static final String LABEL = "test_label";
    private static final double PRICE = 9.99;
    private static final int QUANTITY = 1;

    private ProductStock stock;
    private Product defaultProduct;

    @Before
    public void setUp() {
        this.stock = new Instock();
        this.defaultProduct = new Product(LABEL, PRICE, QUANTITY);
    }

    @Test
    public void testAddProductShouldAddTheProductInsideTheStock() {
        stock.add(defaultProduct);
        assertTrue(stock.contains(defaultProduct));
    }

    @Test
    public void testContainsShouldReturnFalseWhenProductNotPresentAndThenTrueAfterAdded() {
        assertFalse(stock.contains(defaultProduct));
        stock.add(defaultProduct);
        assertTrue(stock.contains(defaultProduct));
    }

    @Test
    public void testAddProductShouldNotAddTheSameProductASecondTime() {
        stock.add(defaultProduct);
        stock.add(defaultProduct);
        assertEquals(1, stock.getCount());
    }

    @Test
    public void testCountShouldReturnTheCorrectNumberOfProducts() {
        // Asserts zero when empty
        assertEquals(0, stock.getCount());

        stock.add(defaultProduct);
        assertEquals(1, stock.getCount());
    }

    @Test
    public void testFindByIndexShouldReturnTheCorrectProductWhenOnlyOnePresent() {
        stock.add(defaultProduct);
        Product product = stock.find(0);
        assertNotNull(product);
        assertEquals(defaultProduct.label, product.label);
    }

    @Test
    public void testFindByIndexShouldReturnTheCorrectProductWhenTheProductIsInBetweenOtherProduct() {
        stubProducts();
        Product product = stock.find(4);
        assertNotNull(product);
        assertEquals("test_label_5", product.label);
    }

    @Test
    public void testFindByIndexShouldReturnTheCorrectProductWhenTheProductIsTheLastOne() {
        stubProducts();
        Product product = stock.find(9);
        assertNotNull(product);
        assertEquals("test_label_10", product.label);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexShouldFailWhenGreaterThanNine() {
        stubProducts();
        stock.find(10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexShouldFailWhenStockIsEmpty() {
        stock.find(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexShouldFailWhenIndexIsNegative() {
        stubProducts();
        stock.find(-1);
    }

    @Test
    public void testChangeQuantityShouldUpdateTheCorrectProductWithTheCorrectAmount() {
        stubProducts();
        stock.add(defaultProduct);
        assertEquals(QUANTITY, defaultProduct.quantity);
        stock.changeQuantity(defaultProduct.label, 13);
        assertEquals(13, defaultProduct.quantity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityShouldFailIfProductIsNotPresent() {
        stubProducts();
        stock.changeQuantity(defaultProduct.label, 13);
    }

    @Test
    public void testFindByLabelShouldReturnTheCorrectProduct() {
        stubProducts();
        stock.add(defaultProduct);
        Product byLabel = stock.findByLabel(defaultProduct.label);
        assertNotNull(byLabel);
        assertEquals(defaultProduct.label, byLabel.label);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelShouldFailWhenProductWithSuchLabelIsNotPresent() {
        stubProducts();
        stock.findByLabel(defaultProduct.label);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollectionWhenStockIsZero() {
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(0);
        List<Product> list = createListFromIterable(iterable);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollectionWhenParameterIsTooLarge() {
        stubProducts();
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(11);
        List<Product> list = createListFromIterable(iterable);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnTheCorrectNumberOfProducts() {
        stubProducts();
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(8);
        List<Product> list = createListFromIterable(iterable);
        assertEquals(8, list.size());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnTheObjectsSorted() {
        stubProducts();
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(8);
        List<Product> list = createListFromIterable(iterable);
        Set<String> expectedLabels = list.stream().map(Product::getLabel).collect(Collectors.toCollection(TreeSet::new));

        int i = 0;
        for (String expectedLabel : expectedLabels) {
            assertEquals(expectedLabel, list.get(i++).getLabel());
        }
    }

    @Test
    public void testFindAllInRangeShouldReturnEmptyCollectionIfNoSuchRangePresent() {
        stubProducts();
        List<Product> products = createListFromIterable(stock.findAllInRange(99999, 9999999));
        assertTrue(products.isEmpty());
    }

    @Test
    public void testFindAllInRangeShouldReturnTheCorrectRange() {
        stubProducts();
        List<Product> products = createListFromIterable(stock.findAllInRange(10.00, 30.00));
        assertEquals(6, products.size());
        for (Product product : products) {
            assertTrue(product.getPrice() > 10.00 && product.getPrice() <= 30.00);
        }
    }

    @Test
    public void testFindAllInRangeShouldReturnProductsOrderedByPriceDescending() {
        stubProducts();
        List<Product> products = createListFromIterable(stock.findAllInRange(10.00, 30.00));

        List<Product> expected = products
                .stream()
                .sorted((f, s) -> Double.compare(s.getPrice(), f.getPrice()))
                .collect(Collectors.toList());

        assertEquals(expected, products);
    }

    @Test
    public void testFindAllByPriceShouldReturnTheCorrectPricedObjects() {
        stubProducts();
        stock.add(defaultProduct);
        List<Product> products = createListFromIterable(stock.findAllByPrice(10.00));
        assertEquals(4, products.size());
        for (Product product : products) {
            assertEquals(10.00, product.price, 0.00);
        }
    }

    @Test
    public void testFindAllByPriceShouldReturnEmptyCollectionIfNoSuchPricedObjectsAreAdded() {
        stubProducts();
        List<Product> products = createListFromIterable(stock.findAllByPrice(99.99));
        assertTrue(products.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsShouldFailIfTheCountIsGreaterThanTheTotalNumberOfProducts() {
        stubProducts();
        stock.findFirstMostExpensiveProducts(stock.getCount() + 1);
    }

    @Test
    public void testFindFirstMostExpensiveProductsShouldTheCorrectMostExpensiveProducts() {
        List<Product> expected = stubProducts()
                .stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .limit(5)
                .collect(Collectors.toList());
        List<Product> products = createListFromIterable(stock.findFirstMostExpensiveProducts(5));
        assertEquals(expected, products);
    }

    @Test
    public void testFindAllByQuantityShouldReturnAnEmptyCollectionIfNoProductHasSuchQuantity() {
        stubProducts();
        List<Product> products = createListFromIterable(stock.findAllByQuantity(100));
        assertTrue(products.isEmpty());
    }

    @Test
    public void testFindAllByQuantityShouldOnlyProductsWithTheMatchingQuantity() {
        stubProducts();
        List<Product> products = createListFromIterable(stock.findAllByQuantity(10));
        assertEquals(5, products.size());
        for (Product product : products) {
            assertEquals(10, product.getQuantity());
        }
    }

    @Test
    public void testIteratorShouldReturnAllProductsInStock() {
        List<Product> expected = stubProducts();

        Iterator<Product> iterator = stock.iterator();
        assertNotNull(iterator);

        int index = 0;
        while (iterator.hasNext()) {
            Product product = iterator.next();
            assertEquals(expected.get(index++).getLabel(), product.getLabel());
        }
    }

    private List<Product> createListFromIterable(Iterable<Product> iterable) {
        assertNotNull(iterable);
        List<Product> products = new ArrayList<>();
        iterable.forEach(products::add);
        return products;
    }

    private List<Product> stubProducts() {
        List<Product> products = Arrays.asList(
                new Product("test_label_1", 10.00, 2),
                new Product("test_label_2", 20.00, 10),
                new Product("test_label_3", 30.00, 10),
                new Product("test_label_4", 15.00, 10),
                new Product("test_label_5", 17.00, 2),
                new Product("test_label_6", 14.99, 2),
                new Product("test_label_7", 10.01, 10),
                new Product("test_label_8", 10.00, 2),
                new Product("test_label_9", 10.00, 10),
                new Product("test_label_10", 10.00, 2)
        );

        for (Product product : products) {
            stock.add(product);
        }

        return products;
    }
}

