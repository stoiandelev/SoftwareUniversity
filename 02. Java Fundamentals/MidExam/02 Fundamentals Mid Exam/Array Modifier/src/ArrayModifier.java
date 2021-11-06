import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String commands=scanner.nextLine();
        while (!commands.equals("end")){

            String firstElement=commands.split("\\s+")[0];

            switch (firstElement){
                case "swap":
                    int indexSwap1=Integer.parseInt(commands.split("\\s+")[1]);
                    int indexSwap2=Integer.parseInt(commands.split("\\s+")[2]);

                    int elementIndex1=numbers.get(indexSwap1);
                    int elementIndex2=numbers.get(indexSwap2);

                    numbers.set(indexSwap1,elementIndex2);
                    numbers.set(indexSwap2,elementIndex1);
                    break;
                case "multiply":
                    int indexMultiply1=Integer.parseInt(commands.split("\\s+")[1]);
                    int indexMultiply2=Integer.parseInt(commands.split("\\s+")[2]);

                    int elementMultiply1=numbers.get(indexMultiply1);
                    int elementMultiply2=numbers.get(indexMultiply2);

                    int indexMultiply=elementMultiply1*elementMultiply2;

                    numbers.set(indexMultiply1,indexMultiply);

                    break;
                case "decrease":
                    for (int i = 0; i <numbers.size() ; i++) {
                        int elementIndex=numbers.get(i);
                        elementIndex-=1;
                        numbers.set(i,elementIndex);

                    }


                    break;
            }

            commands=scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", "")
                .replaceAll(" ", ", "));










    }
}
