import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> friends = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toList());
        String input = scan.nextLine();
        int blacklistedCount = 0;
        int lostCount = 0;
        while (!input.equals("Report")) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Blacklist":
                    if (friends.contains(command[1])) {
                        int friendToBlacklist = friends.indexOf(command[1]);
                        friends.set(friendToBlacklist, "Blacklisted");
                        System.out.println(command[1] + " was blacklisted.");
                        blacklistedCount++;
                    } else {
                        System.out.println(command[1] + " was not found.");
                    }
                    break;
                case "Error":
                    if (!friends.get(Integer.parseInt(command[1])).equals("Blacklisted")
                            && !friends.get(Integer.parseInt(command[1])).equals("Lost")) {
                        System.out.println(friends.get(Integer.parseInt(command[1])) + " was lost due to an error.");
                        friends.set(Integer.parseInt(command[1]), "Lost");
                        lostCount++;
                    }
                    break;
                case "Change":
                    if (Integer.parseInt(command[1]) >= 0 && Integer.parseInt(command[1]) <= friends.size() - 1) {
                        System.out.println(friends.get(Integer.parseInt(command[1])) + " changed his username to " + command[2] + ".");
                        friends.set(Integer.parseInt(command[1]), command[2]);
                    }
            }
            input = scan.nextLine();
        }
        System.out.println("Blacklisted names: " + blacklistedCount);
        System.out.println("Lost names: " + lostCount);
        System.out.println(String.join(" ", friends));
    }
}