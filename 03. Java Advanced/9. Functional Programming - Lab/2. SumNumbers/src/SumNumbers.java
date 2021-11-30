import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] token = scanner.nextLine().split(", ");
        Function<String[], Stream<Integer>> map = arr -> Arrays.stream(arr)
                .map(Integer::parseInt);


        Function<Stream<Integer>, Integer> sum = stream -> stream
                .mapToInt(element -> element).sum();

        Function<Stream<Integer>, Long> count = stream -> stream
                .mapToInt(element -> element).count();

        System.out.println("Count = " + count.apply(map.apply(token)));
        System.out.println("Sum = " + sum.apply(map.apply(token)));

    }
}
