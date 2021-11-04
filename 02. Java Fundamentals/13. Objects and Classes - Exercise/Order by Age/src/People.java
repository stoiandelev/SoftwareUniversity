public class People {
    String name;
    String id;
    int year;

    public People(String name, String id, int year) {
        this.name = name;
        this.id = id;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("%s with ID: %s is %d years old.",name,id,year);



    }
}
