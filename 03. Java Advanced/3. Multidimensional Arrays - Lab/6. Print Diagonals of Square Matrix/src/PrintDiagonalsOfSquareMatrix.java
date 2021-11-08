import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintDiagonalsOfSquareMatrix {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        //дължината при квадратна матрица
        String[][] matrix = reader.lines()
                .limit(Long.parseLong(reader.readLine()))
                .map(line -> line.split("\\s+"))
                .toArray(String[][]::new);

        // първи диагонал
        String one = IntStream.range(0, matrix.length)
                .mapToObj(index -> matrix[index][index])
                .collect(Collectors.joining(" "));
        //втори диагонал
        String two = IntStream.range(0, matrix.length)
                .mapToObj(index -> matrix[matrix.length - index - 1][index])
                .collect(Collectors.joining(" "));

        System.out.println(one);
        System.out.println(two);
    }
}