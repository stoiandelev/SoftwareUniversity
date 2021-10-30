import java.util.Scanner;

public class ProjectsCreation {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String nameArchitect=scanner.nextLine();
        int project=Integer.parseInt(scanner.nextLine());
        while (project < 1 || project > 100){

            System.out.println("Invalid number!");

            project = Integer.parseInt(scanner.nextLine());

        }
        int totalTime=project*3;

        System.out.println("The architect"+" "+nameArchitect+" "+"will need"
                            +" "+totalTime+" "+ "hours to complete"+" "+project+" "+"project/s.");

    }
}
