

import Articles.Articles;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Articles> article = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {


            String command = scanner.nextLine();

            String title = command.split(", ")[0];
            String content = command.split(", ")[1];
            String author = command.split(", ")[2];



            Articles articles = new Articles(title, content, author);
            article.add(articles);
        }

        String input = scanner.nextLine();
        switch (input) {
            case "title":
                article.sort(Comparator.comparing(Articles::getTitle));
                break;
            case "content":
                article.sort(Comparator.comparing(Articles::getContent));
                break;
            case "author":
                article.sort(Comparator.comparing(Articles::getAuthor));
                break;
        }

        for (Articles articles1 : article) {
            System.out.println(articles1);


        }
    }
}



