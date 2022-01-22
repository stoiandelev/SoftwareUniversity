import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class clazz = Reflection.class;
        Field[] declaredFields = clazz.getDeclaredFields();

        //за полетата
        Arrays.stream(declaredFields)
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field -> {
                    if (!Modifier.isPrivate(field.getModifiers())) {
                        System.out.println(field.getName() + " must be private!");
                    }
                });

        Method[] declaredMethods = clazz.getDeclaredMethods();


        //взимаме методите,които са set and get, sort and print
        Arrays.stream(declaredMethods)
                .filter(m -> m.getName().contains("get") || m.getName().contains("set"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(Main::printMethod);
    }

    public static void printMethod(Method method) {
        //тернален оператор
        String out;
        if (method.getName().contains("set") && !Modifier.isPrivate(method.getModifiers())) {
            out = String.format("%s have to be private!", method.getName());
        } else if (method.getName().contains("get") && !Modifier.isPublic(method.getModifiers())) {
            out = String.format("%s have to be public!", method.getName());
        } else {
            return;
        }
        System.out.println(out);
    }

}
