package aquarium.entities.fish;

public class SaltwaterFish extends BaseFish {
    public static final int DEFAULT_SIZE = 5;

    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
    }

    @Override
    public void eat() {
        int size = getSize() + 2;
        setSize(size);
    }
}
