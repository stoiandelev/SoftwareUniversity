import java.util.Scanner;

public class MovieRatings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfMovie=Integer.parseInt(scanner.nextLine());

        double minRating=Double.MAX_VALUE;
        double maxRating=Double.MIN_VALUE;
        String minRatingName="";
        String maxRatingName="";
        double countRating=0;



        for (int i = 1; i <=numOfMovie ; i++) {
                String nameFilm=scanner.nextLine();
                double ratingFilm=Double.parseDouble(scanner.nextLine());
                countRating+=ratingFilm;
                if(ratingFilm>maxRating){
                    maxRating=ratingFilm;
                    maxRatingName=nameFilm;
                }
                if(ratingFilm<minRating){
                    minRating=ratingFilm;
                    minRatingName=nameFilm;
                }

        }
        double averageRating=countRating/numOfMovie;


        System.out.printf("%s is with highest rating: %.1f%n",maxRatingName,maxRating);
        System.out.printf("%s is with lowest rating: %.1f%n",minRatingName,minRating);
        System.out.printf("Average rating: %.1f",averageRating);












    }
}

