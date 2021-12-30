import java.util.*;

public class MakeSalad {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        Map<String,Integer> vegitableCalories=new LinkedHashMap<String,Integer>(){{
            put("tomato",80);
            put("carrot",136);
            put("lettuce",109);
            put("potato",215);
        }};
        ArrayDeque<String> vegetablesStack=new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).filter(x -> x.matches("(tomato|carrot|lettuce|potato)")).forEach(vegetablesStack::offer);
        ArrayDeque<Integer> saladsQueues=new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(saladsQueues::push);
        while (!vegetablesStack.isEmpty() && !saladsQueues.isEmpty()) {
            int currentSalad = saladsQueues.peek();

            while (currentSalad > 0 && !vegetablesStack.isEmpty()) {
                currentSalad -= vegitableCalories.get(vegetablesStack.poll());
            }
            System.out.print(saladsQueues.pop() + " ");
        }
        System.out.println();

        if(!saladsQueues.isEmpty()){
            System.out.println(saladsQueues.toString().replaceAll("[\\[\\],]",""));
        }

        if(!vegetablesStack.isEmpty()){
            System.out.println(vegetablesStack.toString().replaceAll("[\\[\\],]",""));
        }

    }

}