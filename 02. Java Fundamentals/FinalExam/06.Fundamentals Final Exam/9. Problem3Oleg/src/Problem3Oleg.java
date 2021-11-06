import java.util.*;

public class Problem3Oleg {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> guestsCollection = new TreeMap<>();
        //Key: name --> Value: List of meals

        String line = scan.nextLine();
        int counterUnliked = 0;
        while (!line.equals("Stop")) {
            String[] data = line.split("-");
            String action = data[0];
            String name = data[1];
            String meal = data[2];
            switch (action) {
                case "Like":
                    if (!guestsCollection.containsKey(name)) {    //if the guest does not exist ->add the meal to his collect
                        guestsCollection.put(name, new ArrayList<>());
                        guestsCollection.get(name).add(meal);
                    } else {                 //if exists ->add the meal, ONLY IF the meal does NOT exist
                        if (!guestsCollection.get(name).contains(meal)) {
                            guestsCollection.get(name).add(meal);
                        }
                    }
                    break;
                case "Unlike":
                    if (!guestsCollection.containsKey(name)) {  //no such guest
                        System.out.println(name + " is not at the party.");
                    } else { //there Is such guest
                        if (!guestsCollection.get(name).contains(meal)) {   //if the guest does NOT have such meal
                            System.out.printf("%s doesn't have the %s in his/her collection.%n", name, meal);
                        } else {  //if the guest HAS the meal -->remove it, counter++
                            guestsCollection.get(name).remove(meal);
                            counterUnliked++;
                            System.out.printf("%s doesn't like the %s.%n", name, meal);
                        }
                    }

                    break;
            }
            line = scan.nextLine();
        }
        guestsCollection.entrySet().stream()
                .sorted((f, s) -> Integer.compare(s.getValue().size(), f.getValue().size()))
                .forEach(entry -> {
                    System.out.printf("%s: %s%n", entry.getKey(), String.join(", ", entry.getValue()));
                });
        System.out.println("Unliked meals: " + counterUnliked);
    }

}