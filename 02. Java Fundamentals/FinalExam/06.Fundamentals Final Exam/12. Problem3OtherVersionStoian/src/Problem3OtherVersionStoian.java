import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Problem3OtherVersionStoian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer[]> results = new TreeMap<>();
        String command = scanner.nextLine();
        while (!command.equals("Results")){
            String toDo = command.split(":")[0];
            switch (toDo){
                case "Add":
                    String name = command.split(":")[1];
                    int health = Integer.parseInt(command.split(":")[2]);
                    int energy = Integer.parseInt(command.split(":")[3]);
                    if(!results.containsKey(name)){
                        results.put(name, new Integer[2]);
                        results.get(name)[0] = health;
                        results.get(name)[1] = energy;
                        System.out.printf("%s",results.get(name));
                    }else {
                        results.get(name)[0] += health;

                    }
                    break;
                case "Attack":
                    String attackerName = command.split(":")[1];
                    String defenderName = command.split(":")[2];
                    int damage = Integer.parseInt(command.split(":")[3]);
                    if(results.containsKey(attackerName) && results.containsKey(defenderName)){
                        results.get(defenderName)[0] -= damage;
                        if(results.get(defenderName)[0] <= 0){
                            System.out.println(defenderName + " was disqualified!");
                            results.remove(defenderName);
                        }
                        results.get(attackerName)[1] -=1;
                        if(results.get(attackerName)[1] <= 0){
                            System.out.println(attackerName + " was disqualified!");
                            results.remove(attackerName);
                        }
                    }
                    break;
                case "Delete":
                    name = command.split(":")[1];
                    if(name.equals("All")){
                        results.clear();
                    }else{
                        results.remove(name);
                    }
                    break;
            }
            command = scanner.nextLine();

        }
        System.out.println("People count: " +results.size());
        results.entrySet().stream()
                .sorted((a, b) -> b.getValue()[0].compareTo(a.getValue()[0]))
                .forEach(entry -> System.out.printf("%s - %d - %d%n", entry.getKey(), entry.getValue()[0], entry.getValue()[1]));
    }
}