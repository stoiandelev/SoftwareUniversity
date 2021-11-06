import java.util.Scanner;

public class Probmel1FinalRetake {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder stringWord = new StringBuilder(scanner.nextLine());


        String input = scanner.nextLine();


        while (!input.equals("Play")){

            String [] commands = input.split(" ");

            switch (commands[0]){

                case "Move":
                    //Move the letter to the end

                    int letterIndex = Integer.parseInt(commands[1]);
                    char character = stringWord.charAt(letterIndex);

                    if (letterIndex <= 0 || letterIndex >= stringWord.length()-1){
                        break ;
                    }
                    else {

                        stringWord.deleteCharAt(letterIndex);
                        stringWord.insert(stringWord.length() , character);

                    }

                    break;
                case "Insert":
                    // Insert the empty space on the given index

                    if (!commands[1].equals("Space")) {
                        break;
                    }
                    int index = Integer.parseInt(commands[2]);

                    stringWord.insert(index , " ");

                    break;
                case "Reverse":
                    //Cut it reverse and add to the end, only first occurrences
                    String substring = commands[1];
                    String wordForNow = stringWord.toString();

                    StringBuilder reverseString = new StringBuilder();
                    if (wordForNow.contains(substring)){
                        reverseString.append(substring);
                        reverseString.reverse();
                        int startIndex = stringWord.indexOf(substring);
                        int endIndex = startIndex + substring.length();

                        stringWord.delete(startIndex,endIndex);
                        stringWord.insert(stringWord.length(),reverseString);

                        break;
                    }

                    break;
                case "Exchange":

                    if (!commands[1].equals("Tiles")){
                        break;
                    }
                    //Replace the first letter with new letter print separated by single space
                    String newLetters = commands[2];
                    stringWord.delete(0,newLetters.length());
                    stringWord.insert(0,newLetters);

                    for (int i = 0; i < stringWord.length(); i++) {

                        if (i % 2 != 0){
                            stringWord.insert(i," ");
                        }

                    }

                    System.out.println(stringWord);
                    return;

                case "Pass":
                    // print all separated by single space
                    if (commands.length > 1){
                        break;
                    }
                    else {
                        for (int i = 0; i < stringWord.length(); i++) {

                            if (i % 2 != 0){
                                stringWord.insert(i," ");
                            }

                        }

                        System.out.println(stringWord);
                        return;
                    }

            }



            input = scanner.nextLine();

        }

        if (input.equals("Play")){
            //If have empty space -> only letter from start to empty space ->
            String emptySpace = " ";
            String changeString = stringWord.toString();

            if (changeString.contains(emptySpace)){

                int endIndex = stringWord.indexOf(emptySpace);// на кой индекс е празното пространство

                stringWord.delete(0,stringWord.length());//изтриваш целия String

                for (int i = 0; i < endIndex; i++) {

                    char character = changeString.charAt(i);
                    stringWord.append(character);

                }

            }

            System.out.printf("You are playing with the word %s.", stringWord);


        }




    }


}