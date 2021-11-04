import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CompanyUsers {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        TreeMap<String, ArrayList<String>> companies = new TreeMap<>();
        String command = sc.nextLine();

        while (!command.equals("End")) {
            String[] tokens = command.split(" -> ");
            String company = tokens[0];
            String id = tokens[1];

            if (!companies.containsKey(company)) {
                companies.put(company, new ArrayList<String>());
            }
            if (companies.containsKey(company) && !companies.get(company).contains(id)) {
                companies.get(company).add(id);
            }
            command = sc.nextLine();
        }

        for (Map.Entry<String, ArrayList<String>> entry : companies.entrySet()) {
            System.out.println(entry.getKey());
            for (String id : entry.getValue()) {
                System.out.println("-- " + id);
            }
        }


    }

}