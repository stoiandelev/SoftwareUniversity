import java.util.List;

public class Trainer {
    private String name;
    private int badges = 0;
    private List<Pokemon> pokemons;

    public Trainer(String name, int badges, List<Pokemon> pokemons) {
        this.name = name;
        this.badges = badges;
        this.pokemons = pokemons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString() {
        return name + " " + badges + " " + pokemons.size();
    }
}
