package aquarium.entities.fish;

public class FreshwaterFish extends BaseFish {
    public static final int DEFAULT_SIZE = 3;

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
    }

    @Override
    public void eat() {
        int size = getSize() + DEFAULT_SIZE;
        setSize(size);
    }
}
