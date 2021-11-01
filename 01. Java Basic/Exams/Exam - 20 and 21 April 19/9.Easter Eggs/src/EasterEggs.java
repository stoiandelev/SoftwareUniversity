import java.util.Scanner;

public class EasterEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int eggs=Integer.parseInt(scanner.nextLine());

        int redCount=0;
        int orangeCount=0;
        int blueCount=0;
        int greenCount=0;

        int maxEggs=Integer.MIN_VALUE;
        String colorEggs="";


        for (int i = 1; i <=eggs ; i++) {
            String color=scanner.nextLine();
            switch (color){
                case "red":
                    redCount++;
                    if(redCount>maxEggs){
                        maxEggs=redCount;
                        colorEggs=color;
                    }
                    break;
                case "orange":
                    orangeCount++;
                    if(orangeCount>maxEggs){
                        maxEggs=orangeCount;
                        colorEggs=color;
                    }
                    break;
                case "blue":
                    blueCount++;
                    if(blueCount>maxEggs){
                        maxEggs=blueCount;
                        colorEggs=color;
                    }
                    break;
                case "green":
                    greenCount++;
                    if(greenCount>maxEggs){
                        maxEggs=greenCount;
                        colorEggs=color;
                    }
                    break;
            }

        }

        System.out.printf("Red eggs: %d%n",redCount);
        System.out.printf("Orange eggs: %d%n",orangeCount);
        System.out.printf("Blue eggs: %d%n",blueCount);
        System.out.printf("Green eggs: %d%n",greenCount);
        System.out.printf("Max eggs: %d -> %s",maxEggs,colorEggs);



    }
}
