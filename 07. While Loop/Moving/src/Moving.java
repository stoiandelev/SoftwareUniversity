import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int widthFreeSpace = Integer.parseInt(scanner.nextLine());
        int lengthFreeSpace = Integer.parseInt(scanner.nextLine());
        int heightFreeSpace = Integer.parseInt(scanner.nextLine());

        int totalFreeSpace = widthFreeSpace * lengthFreeSpace * heightFreeSpace;

        int sum = 0;

        String input = scanner.nextLine();
        boolean noSpace=false;

        while ((!input.equals("Done"))) {
            int currentBox = Integer.parseInt(input);
            sum += currentBox;
            if (totalFreeSpace < sum) {
                int result = Math.abs(totalFreeSpace - sum);
                System.out.printf("No more free space! You need %d Cubic meters more.", result);
                noSpace=true;
                break;
            }
            input = scanner.nextLine();



        }
        if(!noSpace){
            int resultHaveSpace = Math.abs(sum - totalFreeSpace);
            System.out.printf("%d Cubic meters left.", resultHaveSpace);
        }



    }
}
