import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = List.of(13, 42, 69, -66);

        System.out.println(ListUtilities.getMax(integers));
        System.out.println(ListUtilities.getMin(integers));


    }
}
