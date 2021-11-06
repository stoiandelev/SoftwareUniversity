package MapSorting;

public class SlavSortDiscord {
    public static void main(String[] args) {


        //        // сортира по Value, а ако те са равни сотрира по Key
//        keyMaterials
//                .entrySet()
//                .stream()
//                .sorted((i1, i2) -> {
//                    int result = i2.getValue().compareTo(i1.getValue());
//                    if (result == 0) {
//                        result = i1.getKey().compareTo(i2.getKey());
//                    }
//                    return result;
//                })
//                .forEach(i -> System.out.println(String.format("%s: %d", i.getKey(), i.getValue())));
//




//
//        // sort by Key
//        junkMaterials
//                .entrySet()
//                .stream()
//                .sorted((i1, i2) -> i1.getKey().compareTo(i2.getKey()))
//                .forEach(i -> System.out.println(String.format("%s: %d", i.getKey(), i.getValue())));
//
//




//        // sort a Map by size of a List in Value, and then sort the Strings in the List
//        courses
//                .entrySet()
//                .stream()
//                .sorted((c1, c2) -> Integer.compare(c2.getValue().size(), c1.getValue().size()))
//                .forEach(entry -> {
//                    System.out.println(String.format("%s: %d", entry.getKey(), entry.getValue().size()));
//                    entry
//                            .getValue()
//                            .stream()
//                            .sorted((s1, s2) -> s1.compareTo(s2))
//                            .forEach(s -> System.out.println(String.format("-- %s", s)));
//                });






//         sort a Map by average value in Value List // средно аритметично в List от Value
//        students
//                .entrySet()
//                .stream()
//                .filter(s -> s.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0) >= 4.50)
//                .sorted((s1, s2) -> {
//                    double first = s1.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0);
//                    double second = s2.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0);
//                    return Double.compare(second, first);
//                })
//                .forEach(s -> System.out.println(String.format("%s -> %.2f",
//                        s.getKey(),
//                        s.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0)
//                )));





//        sort Map <String, Map<String, Integer>> , String по азбучен ред, защото е TreeMap, Mapa- по стойността на Integera
//        users
//                .forEach((key, value) -> {
//                    System.out.printf("%s%n", key);
//                    value.entrySet().stream()
//                            .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
//                            .forEach(c -> System.out.printf("# %s -> %d%n", c.getKey(), c.getValue()));
//                });






//        1. сортиране по сойност на Integer във вътрешния Map
//        2. ако са равни - сортиране по азбучен ред
//        3. принтиране на String от външния Map
//        4. подреждане на вътрешния Map по Integer, ако са равни по азбучен ред
//        5. принтиране на вътрешния Map
//        players
//                .entrySet()
//                .stream()
//                .sorted((p1, p2) -> {
//                    int skillOne = p1.getValue().values().stream().mapToInt(Integer::intValue).sum();
//                    int skillTwo = p2.getValue().values().stream().mapToInt((p -> p)).sum();
//                    int result = skillTwo - skillOne;
//                    if (result == 0) {
//                        result = p1.getKey().compareTo(p2.getKey());
//                    }
//                    return result;
//                }).forEach(entry -> {
//            System.out.printf("%s: %d skill%n",
//                    entry.getKey(), entry.getValue().values().stream().mapToInt(Integer::intValue).sum());
//            entry
//                    .getValue()
//                    .entrySet()
//                    .stream()
//                    .sorted((p1, p2) -> {
//                        int result = p2.getValue().compareTo(p1.getValue());
//                        if (result == 0) {
//                            result = p1.getKey().compareTo(p2.getKey());
//                        }
//                        return result;
//                    })
//                    .forEach(p -> System.out.printf("- %s <::> %d%n", p.getKey(), p.getValue()));
//
//
//        });

//
//
//        Сортира по големината на Value и слага от List output Преди печата

//        List<String> output = new ArrayList<>();
//        output.add("1st place: ");
//        output.add("2nd place: ");
//        output.add("3rd place: ");
//
//        racers
//                .entrySet()
//                .stream()
//                .sorted((r1, r2) -> r2.getValue().compareTo(r1.getValue()))
//                .limit(3)
//                .forEach(r -> {
//                    System.out.println(output.remove(0) + r.getKey());
//                });



    }
}
