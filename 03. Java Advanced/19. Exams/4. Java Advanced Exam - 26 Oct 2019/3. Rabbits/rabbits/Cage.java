package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }


    public boolean removeRabbit(String name) {
        return data.removeIf(r -> r.getName().equals(name));
    }

    public void removeSpecies(String species) {
        this.data.removeIf(r -> r.getSpecies().equals(species));
    }

    public Rabbit sellRabbit(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.get(i).setAvailable();
                return this.data.get(i);
            }
        }
        return null;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> soldRabbits = data.stream().filter(r -> r.getSpecies().equals(species)).collect(Collectors.toList());
        data.removeIf(x -> x.getSpecies().equals(species));
        return soldRabbits;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder report = new StringBuilder();
        report.append("Rabbits available at ").append(this.name).append(":").append(System.lineSeparator());
        for (Rabbit datum : data) {
            if(datum.isAvailable()) report.append(datum.toString()).append(System.lineSeparator());
        }
        return report.toString().trim();
    }

    public void add(Rabbit rabbit) {
        if (this.capacity > this.data.size()) {
            this.data.add(rabbit);
        }
    }


}