package SayHello;

public class Bulgarian extends PersonImpl {
    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
