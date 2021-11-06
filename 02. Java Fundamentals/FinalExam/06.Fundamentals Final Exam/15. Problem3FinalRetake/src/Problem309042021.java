import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Problem309042021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> distributor = new TreeMap<>();
        Map<String, Double> client = new TreeMap<>();

        String command = scanner.nextLine();
        double totalIncome=0;
        while (!command.equals("End")) {
            String[] spitCommand = command.split("\\s+");
            String switchCommand = spitCommand[0];



            switch (switchCommand) {
                case "Deliver":
                    String deliverName = spitCommand[1];
                    double costOfIngredientsDelivered = Double.parseDouble(spitCommand[2]);

                    if (!distributor.containsKey(deliverName)) {
                        distributor.put(deliverName, costOfIngredientsDelivered);
                    } else {
                        double currentCost = distributor.get(deliverName);
                        double totalCost = currentCost + costOfIngredientsDelivered;
                        distributor.put(deliverName, totalCost);
                    }

                    break;
                case "Return":
                    String deliveryName = spitCommand[1];
                    double costOfIngredientsReturn = Double.parseDouble(spitCommand[2]);

                    if (!distributor.containsKey(deliveryName)) {
                        break;
                    } else {
                        double currentCost = distributor.get(deliveryName);
                        double afterReturned = currentCost - costOfIngredientsReturn;

                        if (afterReturned <= 0) {
                            distributor.remove(deliveryName);
                        } else {
                            distributor.put(deliveryName, afterReturned);
                        }

                    }


                    break;
                case "Sell":
                    String clientName=spitCommand[1];
                    double moneySpend=Double.parseDouble(spitCommand[2]);

                    if(!client.containsKey(clientName)){
                        client.put(clientName,moneySpend);
                        totalIncome+=moneySpend;
                    }else{
                        double currentSpendMoney=client.get(clientName);
                        double totalSpendMoney=currentSpendMoney+moneySpend;
                        client.put(clientName,totalSpendMoney);
                        totalIncome=totalSpendMoney;
                    }

                    break;


            }


            command = scanner.nextLine();
        }
        client.forEach((key, value) -> System.out.printf("%s: %.2f%n", key, value));
        System.out.println("-----------");
        distributor.forEach((key, value) -> System.out.printf("%s: %.2f%n", key, value));
        System.out.println("-----------");
        System.out.printf("Total Income: %.2f%n",totalIncome);




    }
}
