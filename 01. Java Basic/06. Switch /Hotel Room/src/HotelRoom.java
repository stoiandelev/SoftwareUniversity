import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());


        double totalPriceStudio = 0;
        double totalPriceApartment = 0;
        double priceForStudio = 0;
        double priceForApartment = 0;


        switch (month) {
            case "May":
            case "October":
                if (days <= 7) {
                    priceForStudio = 50;
                    totalPriceStudio = days * priceForStudio;
                    priceForApartment = 65;
                    totalPriceApartment = days * priceForApartment;
                } else if (days <=14) {
                    priceForStudio = 50;
                    totalPriceStudio = days * priceForStudio;
                    totalPriceStudio = totalPriceStudio * 0.95;
                    priceForApartment = 65;
                    totalPriceApartment = days * priceForApartment;

                } else{
                    priceForStudio = 50;
                    totalPriceStudio = days * priceForStudio;
                    priceForApartment = 65;
                    totalPriceApartment = days * priceForApartment;
                    totalPriceStudio = totalPriceStudio * 0.70;
                    totalPriceApartment = totalPriceApartment * 0.90;
                }break;
            case "June":
            case "September":
                if (days <= 7) {
                    priceForStudio = 75.20;
                    totalPriceStudio = days * priceForStudio;
                    priceForApartment = 68.70;
                    totalPriceApartment = days * priceForApartment;
                } else if(days<=14) {
                    priceForStudio = 75.20;
                    totalPriceStudio = days * priceForStudio;
                    priceForApartment = 68.70;
                    totalPriceApartment = days * priceForApartment;
                }else{
                    priceForStudio = 75.20;
                    totalPriceStudio = days * priceForStudio;
                    priceForApartment = 68.70;
                    totalPriceApartment = days * priceForApartment;
                    totalPriceApartment=totalPriceApartment*0.9;
                    totalPriceStudio=totalPriceStudio*0.80;

                }break;
            case "July":
            case "August":
                if (days <= 7) {
                    priceForStudio = 76;
                    totalPriceStudio = days * priceForStudio;
                    priceForApartment = 77;
                    totalPriceApartment = days * priceForApartment;
                } else if(days<=14) {
                        priceForStudio = 76;
                        totalPriceStudio = days * priceForStudio;
                        priceForApartment = 77;
                        totalPriceApartment = days * priceForApartment;
                } else{
                    priceForStudio = 76;
                    totalPriceStudio = days * priceForStudio;
                    priceForApartment = 77;
                    totalPriceApartment = days * priceForApartment;
                    totalPriceApartment = totalPriceApartment * 0.90;
                }break;


        }

        System.out.printf("Apartment: " + "%.2f", totalPriceApartment);
        System.out.println(" lv.");
        System.out.printf("Studio: " + "%.2f", totalPriceStudio);
        System.out.println(" lv.");


    }
}
