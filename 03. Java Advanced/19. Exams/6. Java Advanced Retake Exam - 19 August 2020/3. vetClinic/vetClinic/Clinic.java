package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
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

    public Pet getOldestPet() {
        Pet result = null;
        for (Pet pet : data) {
            if (result == null || result.getAge() < pet.getAge()) {
                result = pet;
            }
        }
        return result;
    }

    public int getCount() {
        return data.size();
    }
    //The clinic has the following patients:
    //{name} {owner}
    //{name} {owner}
    //   (…)"

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:");
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


