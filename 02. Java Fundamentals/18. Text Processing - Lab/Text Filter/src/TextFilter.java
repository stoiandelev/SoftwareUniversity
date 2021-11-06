import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] forbiddenWords =scanner.nextLine().split(", ");
        String input=scanner.nextLine();

        for (String forbiddenWord : forbiddenWords) {
            if(input.contains(forbiddenWord)){
                String wordToStar=convertWordToStarts(forbiddenWord);
                input=input.replace(forbiddenWord,wordToStar);
            }
            

        }
        System.out.println(input);
    }

    private static String convertWordToStarts(String word) {
        StringBuilder wordOfStar= new StringBuilder();
        for (int i = 0; i <word.length() ; i++) {
            wordOfStar.append("*");
        }
        return wordOfStar.toString();
    }
}
