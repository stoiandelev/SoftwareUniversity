package MapSorting;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class AleksandyrGeorgievSort {
    public static void main(String[] args) {




        Map<Integer, String> map = new TreeMap<>
                (Map.of(6, "D", 4, "F", 1, "E", 3, "B", 2, "C", 5, "A"));
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())// <- Сортиране по ключ във възходящ ред
                .forEach(a -> System.out.printf("%d : %s%n", a.getKey(), a.getValue()));
        System.out.println("-----");
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))// <- Сортиране по ключ в низходящ ред
                .forEach(a -> System.out.printf("%d : %s%n", a.getKey(), a.getValue()));
        System.out.println("-----");
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())// <- Сортиране по стойност във възходящ ред
                .forEach(a -> System.out.printf("%d : %s%n", a.getKey(), a.getValue()));
        System.out.println("-----");
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))// <-Сортиране по стойност във низходящ ред
                .forEach(a -> System.out.printf("%d : %s%n", a.getKey(), a.getValue()));
        System.out.println("-----");
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())// <- Сортиране по ключ във възходящ ред
                .filter(a -> a.getKey() % 2 != 0)// <- Взимаме само нечетните
                .forEach(a -> System.out.printf("%d : %s%n", a.getKey(), a.getValue()));

    }
}
