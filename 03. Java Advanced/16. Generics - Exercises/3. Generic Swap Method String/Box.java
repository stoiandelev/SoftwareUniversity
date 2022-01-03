import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add (T element) {
        this.elements.add(element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : elements) {
            sb.append(String.format("%s: %s", element.getClass().getName(), element));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void swap (int firstIndex, int secondIndex) {
        //1. взимаме елементите на дадените индекси
        T firstElement = this.elements.get(firstIndex);
        T secondElement = this.elements.get(secondIndex);

        this.elements.set(secondIndex, firstElement);
        this.elements.set(firstIndex, secondElement);

       /* this.elements.add(firstIndex, secondElement);
        this.elements.remove(firstIndex +  1);
        this.elements.add(secondIndex, firstElement);
        this.elements.remove(secondIndex + 1);*/

    }

}