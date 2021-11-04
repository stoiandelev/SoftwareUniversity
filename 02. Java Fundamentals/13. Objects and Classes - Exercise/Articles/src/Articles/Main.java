package Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String title = input.split(", ")[0];
        String content = input.split(", ")[1];
        String author = input.split(", ")[2];

        Articles articles = new Articles(title, content, author);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            String typeCommand = command.split(": ")[0];
            String newData = command.split(": ")[1];
            switch (typeCommand) {
                case "Edit":
                    articles.edit(newData);
                    break;
                case "ChangeAuthor":
                    articles.changeAuthor(newData);
                    break;
                case "Rename":
                    articles.rename(newData);
                    break;

            }


        }
        System.out.println(articles);


    }
}
