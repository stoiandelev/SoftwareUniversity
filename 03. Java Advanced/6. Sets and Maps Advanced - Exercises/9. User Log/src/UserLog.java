import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class UserLog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> userLogs = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] data = input.split("\\s+");
            String ip = data[0].substring(3);
            String user = data[2].substring(5);

            userLogs.putIfAbsent(user, new LinkedHashMap<>());
            userLogs.get(user).putIfAbsent(ip, 0);
            userLogs.get(user).put(ip, userLogs.get(user).get(ip) + 1);

            input = scanner.nextLine();
        }

        userLogs.forEach((user, data) -> {
            System.out.println(user + ":");

            AtomicInteger counter = new AtomicInteger(0);
            data.forEach((ip, count) -> {
                if (counter.get() == data.size() - 1) {
                    System.out.println(ip + " => " + count + ".");
                } else {
                    System.out.println(ip + " => " + count + ",");
                }

                counter.getAndIncrement();
            });

        });
    }
}