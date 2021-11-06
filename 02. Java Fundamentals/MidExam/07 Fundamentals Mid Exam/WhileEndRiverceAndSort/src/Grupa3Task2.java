import java.util.*;
import java.util.stream.Collectors;

public class Grupa3Task2 {
    public static void main(String[] args) {
        // Input
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> collection = new ArrayList<>();
//        collection = Arrays.asList(input.split(" "));
        collection = new ArrayList<>(Arrays.asList(input.split(" ")));

        String line = scanner.nextLine();
        while(!line.equals("end")){
            String[] lineParsed = line.split(" ");
            if(lineParsed[0].equals("reverse")){
                int start_index = Integer.parseInt(lineParsed[2]);
                int end_index = start_index + Integer.parseInt(lineParsed[4]) - 1;
                for(int i = start_index, reversed_index = end_index, br = 0;
                    br < ((end_index - start_index) + 1) / 2;
                    br++, i++, reversed_index--)
                {
                    String temp = collection.get(i);
                    collection.set(i, collection.get(reversed_index));
                    collection.set(reversed_index, temp);
                }
            } else if(lineParsed[0].equals("sort")){
                Collections.sort(collection.subList(Integer.parseInt(lineParsed[2]),Integer.parseInt(lineParsed[2]) + Integer.parseInt(lineParsed[4])));
            } else if(lineParsed[0].equals("remove")){
                collection.subList(0, Integer.parseInt(lineParsed[1])).clear();
            }
            line = scanner.nextLine();
        }

        System.out.println(collection.stream().collect(Collectors.joining(", ")));
    }
}
