import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;




public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String commands = scanner.nextLine();

        while (!commands.equals("End")) {

            String[] commandSplit = commands.split("\\s+");
            String firstElement = commandSplit[0];

            switch (firstElement) {

                case "Shoot":
                    int indexToShot = Integer.parseInt(commandSplit[1]);
                    int powerToShot = Integer.parseInt(commandSplit[2]);

                    if (indexToShot < 0 || indexToShot >= targets.size()) {
                        break;
                    }

                    int sectionIndex = targets.get(indexToShot);
                    sectionIndex -= powerToShot;

                    if (sectionIndex <= 0) {
                        targets.remove(indexToShot);
                    } else {
                        targets.set(indexToShot, sectionIndex);
                    }

                    break;
                case "Add":
                    int index = Integer.parseInt(commandSplit[1]);
                    int value = Integer.parseInt(commandSplit[2]);

                    if (index < 0 || index >= targets.size()) {
                        System.out.println("Invalid placement!");
                        break;
                    } else {
                        targets.add(index, value);
                    }


                    break;
                case "Strike":
                    int indexStrike = Integer.parseInt(commandSplit[1]);
                    int radius = Integer.parseInt(commandSplit[2]);

                    if (indexStrike - radius >= 0 && indexStrike + radius < targets.size()) {

                        targets.subList(indexStrike - radius, indexStrike + radius + 1).clear();

                    } else {
                        System.out.println("Strike missed!");
                    }


                    break;
            }


            commands = scanner.nextLine();
        }

        System.out.println(targets.toString().replaceAll("[\\[\\],]", "")
                .replaceAll(" ", "|"));

    }


}
