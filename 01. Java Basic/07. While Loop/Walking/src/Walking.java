import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalSteps=0;

        String input=scanner.nextLine();

        while(!input.equals("Going home")){
            int steps=Integer.parseInt(input);
            totalSteps+=steps;
            if(totalSteps>10000){
                break;
            }
            input=scanner.nextLine();
        }
        if(input.equals("Going home")){
            int stepsToHome=Integer.parseInt(scanner.nextLine());
            totalSteps+=stepsToHome;
        }
        if(totalSteps>=10000){
            int overGoal=totalSteps-10000;
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!",overGoal);
        }else{
            System.out.printf("%d more steps to reach goal.",Math.abs(10000-totalSteps));

        }













    }
}
