import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalFloors=Integer.parseInt(scanner.nextLine());
        int totalRooms=Integer.parseInt(scanner.nextLine());

        for (int floor = totalFloors; floor >=1 ; floor--) {
            for (int room = 0; room <totalRooms ; room++) {
                if(floor==totalFloors){
                    System.out.printf("L%d%d ",floor,room);
                }else if(floor%2==0){
                    System.out.printf("O%d%d ",floor,room);
                }else{
                    System.out.printf("A%d%d ",floor,room);
                }
            }
            System.out.println();
        }


















    }
}
