import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> emailsData = new LinkedHashMap<>();

        String name = scanner.nextLine();
        while (!name.equals("stop")) {

            String email = scanner.nextLine();
            //"us", "uk" or “com
            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                emailsData.put(name, email);
            }
            name = scanner.nextLine();
        }

        //{name} – > {email}
        emailsData.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
