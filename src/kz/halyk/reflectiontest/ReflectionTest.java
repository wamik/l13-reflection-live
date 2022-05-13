package kz.halyk.reflectiontest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;


public class ReflectionTest {

    public static void main(String[] args) throws ReflectiveOperationException {

        //извлечь имя класса из аргументов командной строки или
        // введенных пользователем данных
        String name;
        if (args.length > 0)
            name = args[0];
        else {
            var in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date): ");
            name = in.next();

        }
        // вывести имя класса и суперкласса (if != Object)
        Class cl = Class.forName(name);
        Class supercl = cl.getSuperclass();
        String modifiers = Modifier.toString(cl.getModifiers());
        if (modifiers.length() > 0)
            System.out.print(modifiers + " ");

        System.out.print("class " + name);

        if (supercl != null && supercl != Object.class)
            System.out.print(" extends " + supercl.getName());

        System.out.print("\n{\n");
        printConstructors(cl);
        System.out.println();
        printMethods(cl);
        System.out.println();
        printFields(cl);
        System.out.println("}");

    }

    private static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            Class<?> type = field.getType();
            String name = field.getName();

            System.out.print(" ");
            String modifiers = Modifier.toString(field.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }

    private static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();

        for (Method m : methods) {
            Class<?> returnType = m.getReturnType();
            String name = m.getName();

            System.out.print(" ");
            // вывести модификаторы, возвращаемы тип, а также имя метода
            String modifiers = Modifier.toString(m.getModifiers());

            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");

            System.out.print(returnType.getName() + " " + name + "(");

            // Вывести типы параметров
            Class<?>[] parameterTypes = m.getParameterTypes();
            String paramNames = Arrays.stream(parameterTypes)
                    .map(paramType -> paramType.getName())
                    .collect(Collectors.joining(", "));

            System.out.print(paramNames);
            System.out.println(");");
        }
    }

    private static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.println(" ");
            String modifiers = Modifier.toString(c.getModifiers());

            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");

            System.out.print(name + "(");

            // Вывести типы параметров
            Class[] parameterTypes = c.getParameterTypes();
            String paramNames = Arrays.stream(parameterTypes)
                    .map(paramType -> paramType.getName())
                    .collect(Collectors.joining(", "));

            System.out.print(paramNames);
            System.out.println(");");
        }
    }
}
