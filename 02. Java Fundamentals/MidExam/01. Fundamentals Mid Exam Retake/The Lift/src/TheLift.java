import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        List<Integer> lifts = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        //      if(people > 0) {
        for (int i = 0; i < lifts.size(); i++) {
            int toAdd = 0;
            if (lifts.get(i) < 4) {
                toAdd = 4 - lifts.get(i);
                if (toAdd <= people) {
                    lifts.set(i, lifts.get(i) + toAdd);
                } else if(people > 0){
                    lifts.set(i, lifts.get(i) + people);
                }
            }
            people -= toAdd;
        }
//        }

        boolean isFull = true;
        for (int i = 0; i < lifts.size(); i++) {

            if(lifts.get(i) < 4){
                isFull = false;
            }
        }
        if(people == 0 && isFull){
            System.out.println(lifts.toString().replaceAll("[\\[\\],]", ""));
        } else if(people > 0){
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
            System.out.println(lifts.toString().replaceAll("[\\[\\],]", ""));

        }else {
            System.out.println("The lift has empty spots!");
            System.out.println(lifts.toString().replaceAll("[\\[\\],]", ""));
        }



    }
}