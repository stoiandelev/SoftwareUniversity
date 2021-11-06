import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Grupa2Task2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> sugarCubes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Mort")) {
            String[] commands = input.split("\\s+");

            switch (commands[0]) {
                case "Add":
                    addElement(commands, sugarCubes);
                    break;
                case "Remove":
                    removeElement(commands, sugarCubes);
                    break;
                case "Replace":
                    replaceOldElement(commands, sugarCubes);
                    break;
                case "Collapse":
                    collapseEqualElements(commands, sugarCubes);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(sugarCubes.toString().replaceAll("[\\[\\],]",""));
    }

    private static void addElement(String[] commands, List<Integer> sugarCubes) {
        int value = Integer.parseInt(commands[1]);

        sugarCubes.add(sugarCubes.size(), value);
    }

    private static void removeElement(String[] commands, List<Integer> sugarCubes) {
        int value = Integer.parseInt(commands[1]);
        int index = 0;
        for (int cubes : sugarCubes) {
            if (cubes == value) {
                index = sugarCubes.indexOf(cubes);
                break;
            }

        }
        sugarCubes.remove(index);
    }

    private static void replaceOldElement(String[] commands, List<Integer> sugarCubes) {
        int value = Integer.parseInt(commands[1]);
        int replacement = Integer.parseInt(commands[2]);
        int index = 0;
        for (int cubes : sugarCubes) {
            if (cubes == value) {
                index = sugarCubes.indexOf(cubes);
                break;
            }
        }
        sugarCubes.set(index, replacement);
    }

    private static void collapseEqualElements(String[] commands, List<Integer> sugarCubes) {
        int value = Integer.parseInt(commands[1]);
        int endIndex = sugarCubes.size()-1;
        int startIndex = 0;
        while (!(startIndex==endIndex+1)){
            int cube = sugarCubes.get(startIndex);

            if (cube < value){
                sugarCubes.remove(startIndex);
                endIndex = sugarCubes.size()-1;
            }else {
                startIndex++;
            }
        }
    }
}
