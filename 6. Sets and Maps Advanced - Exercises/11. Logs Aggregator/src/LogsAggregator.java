import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, TreeMap<String, Integer>> logsData = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            // <IP> <user> <duration>
            String[] input = scanner.nextLine().split(" ");
            String ip = input[0];
            String user = input[1];
            int duration = Integer.parseInt(input[2]);

            logsData.putIfAbsent(user, new TreeMap<>());
            TreeMap<String, Integer> innerMap = logsData.get(user);
            innerMap.putIfAbsent(ip, 0);
            innerMap.put(ip, innerMap.get(ip) + duration);
        }
        // <user>: <duration> [<IP1>, <IP2>, …]
        logsData.entrySet().forEach(e -> {
            System.out.printf("%s: %d ", e.getKey(), e.getValue().values().stream().mapToInt(i -> i).sum());
            System.out.printf("[%s]%n", String.join(", ", e.getValue().keySet()));
        });
    }
}