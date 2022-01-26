package bankSafe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class BankVaultTest {

    private BankVault bankVault;

    @Before
    public void init() {
        this.bankVault = new BankVault();
    }

    @Test
    public void test() {

    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetVaultCells() {
        BankVault bankVault = new BankVault();
        bankVault.getVaultCells().put("D3", null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddItemWrongCell() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        bankVault.addItem("D", null);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWrong() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("Asen", "Marian");

        bankVault.addItem("A1", item);
        bankVault.addItem("A1", item);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddWrongSecond() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        bankVault.addItem("A1", null);

    }

    @Test
    public void testAddMethodWorksProperly() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("Pesho", "test");
        bankVault.addItem("A1", item);
        Assert.assertEquals(bankVault.getVaultCells().get("A1"), item);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCellDoesNotExist() {
        BankVault bankVault = new BankVault();
        bankVault.removeItem("D3", null);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemDoesNotExist() {
        BankVault bankVault = new BankVault();
        Item item2 = new Item("petar", "opa");
        bankVault.removeItem("A1", item2);

    }

    @Test
    public void testRemoveItemWorksProperly() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("Gosho", "OPa");
        bankVault.addItem("A1", item);
        bankVault.removeItem("A1", item);
        Assert.assertNull(bankVault.getVaultCells().get("A1"));
    }

    @Test
    public void testRemoveReturnProperMessage() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("Gosho", "OPa");
        bankVault.addItem("A1", item);
        String expected = String.format("Remove item:%s successfully!", item.getItemId());
        String actual = bankVault.removeItem("A1", item);
        Assert.assertEquals(expected, actual);

    }


}