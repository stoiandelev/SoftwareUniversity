package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;


    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.capacity > this.data.size()) {
            this.data.add(pet);
        }
    }
    public boolean remove(String name) {
        return data.removeIf(r -> r.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : this.data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:");
        sb.append(System.lineSeparator());
        for (Pet pet : data) {
            sb.append(pet.getName());
            sb.append(" ");
            sb.append(pet.getOwner());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
