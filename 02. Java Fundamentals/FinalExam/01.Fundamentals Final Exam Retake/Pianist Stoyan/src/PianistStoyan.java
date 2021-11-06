import java.util.*;

public class PianistStoyan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        Map<String, String> pieceComposer = new TreeMap<>();
        Map<String, String> pieceKey = new TreeMap<>();

        for (int i = 0; i < number; i++) {
            //{piece}|{composer}|{key}
            String[] splitCommand = scanner.nextLine().split("\\|");

            String name = splitCommand[0];
            String composer = splitCommand[1];
            String key = splitCommand[2];

            pieceComposer.put(name, composer);
            pieceKey.put(name, key);

        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] spitCommand = command.split("\\|");

            //Add|{piece}|{composer}|{key}

            String switchCommand = spitCommand[0];
            String pieceName = spitCommand[1];

            switch (switchCommand) {
                case "Add":
                    //Add|{piece}|{composer}|{key}

                    String composer = spitCommand[2];
                    String key = spitCommand[3];

                    if (pieceComposer.containsKey(pieceName)) {
                        System.out.printf("%s is already in the collection!%n", pieceName);
                        break;
                    } else {
                        pieceComposer.put(pieceName, composer);
                        pieceKey.put(pieceName, key);
                        System.out.printf("%s by %s in %s added to the collection!%n", pieceName, composer, key);
                    }
                    break;
                case "Remove":
                    //Remove|{piece}
                    if (!pieceComposer.containsKey(pieceName)) {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceName);
                    } else {
                        pieceComposer.remove(pieceName);
                        pieceKey.remove(pieceName);
                        System.out.printf("Successfully removed %s!%n", pieceName);
                    }
                    break;
                case "ChangeKey":
                    //ChangeKey|{piece}|{new key}

                    String newKey = spitCommand[2];

                    if (!pieceComposer.containsKey(pieceName)) {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceName);
                    } else {
                        pieceKey.put(pieceName, newKey);
                        System.out.printf("Changed the key of %s to %s!%n", pieceName, newKey);
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        //sorted by their name and by the name of their composer in alphabetical order
        //{Piece} -> Composer: {composer}, Key: {key}

        pieceComposer.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(k->{
                    System.out.printf("%s -> Composer: %s, Key: %s%n",k.getKey(),k.getValue(),pieceKey.get(k.getKey()));
                });


    }
}
