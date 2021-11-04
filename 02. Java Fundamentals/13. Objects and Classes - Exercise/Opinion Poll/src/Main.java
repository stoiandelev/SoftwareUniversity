import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number=Integer.parseInt(scanner.nextLine());
        List<Person> people=new ArrayList<>();
        for (int i = 0; i <number ; i++) {
            String command=scanner.nextLine();

            String name=command.split("\\s+")[0];
            int age=Integer.parseInt(command.split("\\s+")[1]);

            if(age>30){
                Person person=new Person(name,age);
                people.add(person);
            }




        }
        people.sort(Comparator.comparing(Person::getName));

        for (Person person : people) {
            System.out.println(person);
        }






    }
}
