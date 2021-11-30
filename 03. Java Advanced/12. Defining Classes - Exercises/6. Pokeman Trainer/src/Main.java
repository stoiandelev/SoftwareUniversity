
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Trainer> trainers = new ArrayList<>();
        String input = sc.nextLine();
        while (!input.equals("Tournament")) {
            String name = input.split("\\s+")[0];
            int index = -1;
            for (int i = 0; i < trainers.size(); i++) {
                if (trainers.get(i).getName().equals(name)) index = i;
            }
            String pokemonName = input.split("\\s+")[1];
            String pokemonElement = input.split("\\s+")[2];
            int pokemonHealth = Integer.parseInt(input.split("\\s+")[3]);
            Pokemon current = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if (index != -1) {
                trainers.get(index).getPokemons().add(current);
            } else {
                Trainer currentTrainer = new Trainer(name, 0, new ArrayList<>());
                trainers.add(currentTrainer);
                trainers.get(trainers.size() - 1).getPokemons().add(current);
            }
            input = sc.nextLine();
        }
        input = sc.nextLine();
        while (!input.equals("End")) {
            String element = input;

            for (int i = 0; i < trainers.size(); i++) {
                boolean hasGot = false;
                for (int j = 0; j < trainers.get(i).getPokemons().size(); j++) {
                    if (trainers.get(i).getPokemons().get(j).getElement().equals(element) && trainers.get(i).getPokemons().get(j).getHealth()>10) {
                        trainers.get(i).setBadges(trainers.get(i).getBadges() + 1);
                        hasGot = true;
                        break;
                    }
                }
                if (!hasGot) {
                    for (int j = 0; j < trainers.get(i).getPokemons().size(); j++) {
                        trainers.get(i).getPokemons().get(j).setHealth(trainers.get(i).getPokemons().get(j).getHealth() - 10);
                        if (trainers.get(i).getPokemons().get(j).getHealth() < 0) {
                            trainers.get(i).getPokemons().remove(j);
                        }
                    }
                }
            }

            input = sc.nextLine();
        }
        trainers.stream().sorted((e,d)-> Integer.compare(d.getBadges(), e.getBadges())).forEach(System.out::println);
    }
}
