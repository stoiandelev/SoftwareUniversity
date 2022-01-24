package Skeletons.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        //обект от класа
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();
        //всички методи
        List<Method> methods = Arrays.asList(clazz.getDeclaredMethods());
        //полето
        Field innerValue = clazz.getDeclaredField("innerValue");


        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            //add_999999//subtract_19//divide_4//multiply_2//rightShift_1//leftShift_3
            String command = input.split("_")[0];
            int value = Integer.parseInt(input.split("_")[1]);

            //намеря кой е метода
            Method currentMethod = methods.stream()
                    .filter(method -> method.getName().equals(command))
                    .findFirst()
                    .orElse(null);

            //да го изпълня
            currentMethod.setAccessible(true);
            currentMethod.invoke(blackBoxInt, value);

            innerValue.setAccessible(true);
            System.out.println(innerValue.get(blackBoxInt));
            input = scanner.nextLine();
        }


    }
}
