import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class probaMapSort {
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



        /*health and energy in descending order, name in ascending order
        nameHealth.entrySet().stream()
                .sorted((a, b) -> {
                    if (a.getValue() != b.getValue()) {
                        return Integer.compare(b.getValue(), a.getValue());
                    } else {
                        int aEnergy = nameEnergy.get(a.getKey());
                        int bEnergy = nameEnergy.get(b.getKey());

                        return Integer.compare(bEnergy, aEnergy);
                    }
                })
                .map(e -> String.format("%s - %d - %d", e.getKey(), nameHealth.get(e.getKey()), nameEnergy.get(e.getKey())))
                .forEach(System.out::println);
            */




             /*nameHealth.entrySet().stream()
                .sorted((f, s) -> {
                        int result = Integer.compare(s.getValue,f.getValue);
                        if(result==0)
                        result=f.getKey.compareTos.getKey

                        return result
                    }
                })
                .map(e -> String.format("%s - %d - %d", e.getKey(), nameHealth.get(e.getKey()), nameEnergy.get(e.getKey())))
                .forEach(System.out::println);
            */

        










    }
}