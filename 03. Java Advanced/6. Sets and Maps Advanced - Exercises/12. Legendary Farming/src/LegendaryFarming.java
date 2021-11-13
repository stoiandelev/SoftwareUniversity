import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> keyMaterial = new HashMap<>();
        Map <String,Integer> junkMaterial = new TreeMap<>();
        boolean isObtained = false;
        keyMaterial.put("shards", 0);
        keyMaterial.put("fragments", 0);
        keyMaterial.put("motes", 0);

        while (!isObtained){
            String[] tokens = scanner.nextLine().split("\\s+");

            for (int i = 0; i < tokens.length; i+=2) {
                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i+1].toLowerCase();

                if(material.equals("shards") || material.equals("motes") || material.equals("fragments")){
                    keyMaterial.put(material, keyMaterial.get(material) + quantity);
                    if(keyMaterial.get(material)>=250){
                        keyMaterial.put(material, keyMaterial.get(material)-250);
                        if(material.equals("shards")){
                            System.out.println("Shadowmourne obtained!");
                        }
                        else if(material.equals("motes")){
                            System.out.println("Dragonwrath obtained!");
                        }
                        else{
                            System.out.println("Valanyr obtained!");
                        }
                        isObtained = true;
                        break;
                    }
                }
                else {
                    junkMaterial.putIfAbsent(material, 0);
                    junkMaterial.put(material, junkMaterial.get(material)+quantity);
                }
            }
        }
        keyMaterial.entrySet().stream()
                .sorted(Map.Entry.<String, Integer> comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        junkMaterial.forEach((k,v) -> System.out.println(k + ": " + v));
    }
}
