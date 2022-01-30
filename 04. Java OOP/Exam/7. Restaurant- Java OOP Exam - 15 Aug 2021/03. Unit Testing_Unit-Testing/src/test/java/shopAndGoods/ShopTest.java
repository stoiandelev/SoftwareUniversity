package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {
    private Shop shop;

    @Before
    public void setUp() {
        this.shop = new Shop();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDoesntExitKey() throws OperationNotSupportedException {
        Shop shop = new Shop();
        shop.addGoods("S1",null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCellsIsNull() throws OperationNotSupportedException {
        Shop shop   = new Shop();
        shop.addGoods("Shelves1",null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testItemsAlreadyExist() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("Stoian","Marian");
        shop.addGoods("Shelves1",goods);
        shop.addGoods("Shelves1",goods);

    }

    @Test
    public void testCorrectAdd() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("Stoian","Marian");
        shop.addGoods("Shelves1",goods);
        Assert.assertEquals(shop.getShelves().get("Shelves1"),goods);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testRemoveDoesntExitKey() throws OperationNotSupportedException {
        Shop shop = new Shop();
        shop.removeGoods("S1",null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCellsDoesExits() {
        Shop bankVault = new Shop();
        Goods goods = new Goods("Stoian","Marian");
        bankVault.removeGoods("Shelves1",goods);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveCellsNull() {
        Shop shop = new Shop();
        shop.removeGoods("Shelves1",null);
    }

    @Test
    public void testRemoveCorrect() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("Stoian","Marian");
        shop.addGoods("Shelves1",goods);
        shop.removeGoods("Shelves1",goods);
        Assert.assertNull(shop.getShelves().get("Shelves1"));
    }




















}