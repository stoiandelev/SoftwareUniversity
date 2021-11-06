package MapSorting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesislavaTopuzokovaSoftUni {
    public static void main(String[] args) {


        //Sorting map by value (list) count:

        //Map with value list -> sorting by count of list elements
        Map<String, List<String>> map = new HashMap<>();
        map
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().size() - a.getValue().size())
                .forEach(pair -> {
                    System.out.println(pair.getKey());
                    pair.getValue().forEach(el -> System.out.println(el));
                });











    }
}
