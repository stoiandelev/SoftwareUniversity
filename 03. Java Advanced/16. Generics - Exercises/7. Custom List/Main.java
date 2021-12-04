import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String>  customList = new CustomList<>();
        String command = scanner.nextLine();
        while(!command.equals("END")) {
            //•	Add <element> - Adds the given element to the end of the list
            //•	Remove <index> - Removes the element at the given index
            //•	Contains <element> - Prints if the list contains the given element (true or false)
            //•	Swap <index> <index> - Swaps the elements at the given indexes
            //•	Greater <element> - Counts the elements that are greater than the given element and prints their count
            //•	Max - Prints the maximum element in the list
            //•	Min - Prints the minimum element in the list
            //•	Print - Prints all elements in the list, each on a separate line
            String[] tokens = command.split("\\s+");
            String commandName = tokens[0];

            switch(commandName) {
                case "Add":
                    String elementToAdd = tokens[1];
                    customList.add(elementToAdd);
                    break;
                case "Remove":
                    int removedIndex = Integer.parseInt(tokens[1]);
                    customList.remove(removedIndex);
                    break;
                case "Contains":
                    String searchedElement = tokens[1];
                    System.out.println(customList.contains(searchedElement));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String element = tokens[1];
                    System.out.println(customList.countGreaterThan(element));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    for(String el : customList) {
                        System.out.println(el);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
