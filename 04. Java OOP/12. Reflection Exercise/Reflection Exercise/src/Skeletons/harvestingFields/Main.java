package Skeletons.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //взимаме всички полета
        List<Field> fields = Arrays.asList(RichSoilLand.class.getDeclaredFields());

        Map<Commands, List<Field>> modifiersFieldsMap = getMap(fields);
        fillMapWithFields(fields, modifiersFieldsMap);

        String input = scanner.nextLine();

        Consumer<Field> printer = field -> {
            StringBuilder builder = new StringBuilder();
            builder.append(Modifier.toString(field.getModifiers()))
                    .append(" ")
                    .append(field.getType().getSimpleName())
                    .append(" ")
                    .append(field.getName());

            System.out.println(builder.toString());

        };

        while (!input.equals("HARVEST")) {
            //•	private - print all private fields
            //•	protected - print all protected fields
            //•	public - print all public fields
            //•	all - print ALL declared fields
            switch (input) {
                case "private":
                    modifiersFieldsMap.get(Commands.PRIVATE).forEach(printer::accept);
                    break;
                case "public":
                    modifiersFieldsMap.get(Commands.PUBLIC).forEach(printer::accept);
                    break;
                case "protected":
                    modifiersFieldsMap.get(Commands.PROTECTED).forEach(printer::accept);
                    break;
                case "all":
                    modifiersFieldsMap.get(Commands.ALL).forEach(printer::accept);
                    break;
            }

            input = scanner.nextLine();
        }

    }

    private static void fillMapWithFields(List<Field> fields, Map<Commands, List<Field>> modifiersFieldsMap) {
        for (Field field : fields) {
            //връща какъв е modifier
            String modifier = Modifier.toString(field.getModifiers());
            switch (modifier) {
                case "public":
                    modifiersFieldsMap.get(Commands.PUBLIC).add(field);
                    break;
                case "private":
                    modifiersFieldsMap.get(Commands.PRIVATE).add(field);
                    break;
                case "protected":
                    modifiersFieldsMap.get(Commands.PROTECTED).add(field);
                    break;
            }
        }
    }

    private static Map<Commands, List<Field>> getMap(List<Field> fields) {
        Map<Commands, List<Field>> modifiersFieldsMap = new LinkedHashMap<>();
        modifiersFieldsMap.put(Commands.PUBLIC, new ArrayList<>());
        modifiersFieldsMap.put(Commands.PRIVATE, new ArrayList<>());
        modifiersFieldsMap.put(Commands.PROTECTED, new ArrayList<>());
        modifiersFieldsMap.put(Commands.ALL, fields);
        return modifiersFieldsMap;
    }
}
