import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfElement=scanner.nextInt();
        int numberOfPoll=scanner.nextInt();
        int numberOfContent=scanner.nextInt();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numberOfElement; i++) {
            queue.offer(scanner.nextInt());
        }
        for (int i = 0; i < numberOfPoll ; i++) {
            queue.poll();
        }
        if(queue.contains(numberOfContent)){
            System.out.println("true");
        }else if(!queue.isEmpty()){
            System.out.println(Collections.min(queue));
        }else{
            System.out.println("0");
        }
    }
}
