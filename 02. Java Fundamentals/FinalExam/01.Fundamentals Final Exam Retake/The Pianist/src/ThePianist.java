import java.util.*;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> piecesAll = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\|");
            //{piece}|{composer}|{key}

            String pieceName = input[0];
            String composer = input[1];
            String key = input[2];

            piecesAll.put(pieceName, new ArrayList<>());
            piecesAll.get(pieceName).add(composer);
            piecesAll.get(pieceName).add(key);


        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] commands = command.split("\\|");
            //Add|{piece}|{composer}|{key}

            String typeCommand = commands[0];
            String piece = commands[1];

            switch (typeCommand) {
                case "Add":
                    ////Add|{piece}|{composer}|{key}
                    String composer = commands[2];
                    String key = commands[3];

                    if (piecesAll.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                    } else {
                        piecesAll.put(piece, new ArrayList<>());
                        piecesAll.get(piece).add(composer);
                        piecesAll.get(piece).add(key);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    }

                    break;
                case "Remove":
                    //Remove|{piece}
                    if (piecesAll.containsKey(piece)) {
                        piecesAll.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }

                    break;
                case "ChangeKey":
                    //ChangeKey|{piece}|{new key}
                    String newKey = commands[2];
                    if (piecesAll.containsKey(piece)) {
                        piecesAll.get(piece).set(1, newKey);
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }

                    break;
            }


            command = scanner.nextLine();
        }

        //name and by the name of their composer in alphabetical order,
        // {Piece} -> Composer: {composer}, Key: {key}

        piecesAll.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(p -> System.out.printf("%s -> Composer: %s, Key: %s%n",
                        p.getKey(), p.getValue().get(0), p.getValue().get(1)));
    }
}
