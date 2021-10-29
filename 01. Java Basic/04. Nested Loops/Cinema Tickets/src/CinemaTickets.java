import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int standardTicketsSum = 0;
        int kidsTicketsSum = 0;
        int studentTicketsSum = 0;


        String nameFilm = scanner.nextLine();

        while (!nameFilm.equals("Finish")) {
            int freeSpace = Integer.parseInt(scanner.nextLine());
            int totalTickets = 0;

            for (int i = 0; i < freeSpace; i++) {
                String type = scanner.nextLine();
                if (type.equals("End")) {
                    break;
                }
                totalTickets++;

                switch (type) {
                    case "student":
                        studentTicketsSum++;
                        break;
                    case "kid":
                        kidsTicketsSum++;
                        break;
                    case "standard":
                        standardTicketsSum++;
                        break;
                }

            }
            double hall = 1.0 * totalTickets / freeSpace * 100;
            System.out.printf("%s - %.2f%% full.%n", nameFilm, hall);
            nameFilm=scanner.nextLine();
        }
        int allTotalTickets=standardTicketsSum+studentTicketsSum+kidsTicketsSum;
        System.out.printf("Total tickets: %d%n",allTotalTickets);

        double studentPersent=(100.00/allTotalTickets)*studentTicketsSum;
        System.out.printf("%.2f%% student tickets.%n",studentPersent);

        double standartPersent=(100.00/allTotalTickets)*standardTicketsSum;
        System.out.printf("%.2f%% standard tickets.%n",standartPersent);

        double kidPersent=(100.00/allTotalTickets)*kidsTicketsSum;
        System.out.printf("%.2f%% kids tickets.%n",kidPersent);


    }
}
