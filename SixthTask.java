import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SixthTask {
    // Пункт a
    public static double Average(List<Integer> list){

        return list.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }

    // Пункт b
    public static List<String> FormattedString(List<String> list){

        return list.stream().map(String::toUpperCase).map(s -> "new" + s).collect(Collectors.toList());

    }

    // Пункт c
    public static List<Integer> SquaresList(List<Integer> list){

        return list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(s -> s.getValue() == 1)
                .map(s -> s.getKey() * s.getKey()).collect(Collectors.toList());

    }

    // Пункт d
    public static List<String> ListFiltering(List<String> list, char letter){

        return list.stream().filter(s -> s.startsWith(String.valueOf(letter))).sorted()
                .collect(Collectors.toList());

    }

    // Пункт e
    public static <T> T LastElement(Collection<T> list){

        return list.stream().reduce((a, b) -> b).orElseThrow(() -> new NoSuchElementException("Коллекция пуста"));

    }

    // Пункт f
    public static int SumOfIntegers(int[] list){

        return Arrays.stream(list).filter(i -> i % 2 == 0).sum();
    }

    // Пункт g
    public static Map<Character, String> ListToMap(List<String> list){
        return list.stream().collect(Collectors
                .toMap(s -> s.charAt(0), s -> s.substring(1), (a, b) -> a));
    }

    public static void main(String[] args) {

        // Проверка
        System.out.println("Пункт a:");
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("Среднее значение списка: " + Average(list1));

        System.out.println("Пункт b:");
        List<String> list2 = new ArrayList<>(Arrays.asList("apple", "peach", "orange"));
        System.out.println("Форматированный список:" + FormattedString(list2));

        System.out.println("Пункт с:");
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 5, 5, 4, 9));
        System.out.println("Список квадратов уникальных элементов:" + SquaresList(list3));

        System.out.println("Пункт d:");
        List<String> list4 = new ArrayList<>(Arrays.asList("jockey", "java", "universe", "table"));
        System.out.println("Отсортированный список:" + ListFiltering(list4, 'j'));

        System.out.println("Пункт e:");
        List<Integer> list5 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("Последний элемент list5: " + LastElement(list5));

        System.out.println("Пункт f:");
        int[] list7 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] list8 = new int[]{1, 3, 5, 7, 9};
        System.out.println("Сумма чётных чисел: " + SumOfIntegers(list7));
        System.out.println("Сумма чётных чисел: " + SumOfIntegers(list8));

        System.out.println("Пункт g:");
        List<String> list9 = new ArrayList<>(Arrays.asList("apple", "peach", "orange"));
        System.out.println("Список в Map:" + ListToMap(list9));
    }
}
