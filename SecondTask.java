import java.util.function.Predicate;

public class SecondTask {
    public static void main(String[] args) {

        Predicate<String> FirstJ = s -> s.startsWith("J");
        Predicate<String> FirstN = s -> s.startsWith("N");
        Predicate<String> LastA = s -> s.endsWith("A");

        Predicate<String> Condition = (FirstJ.or(FirstN)).and(LastA);

        // Проверка
        String str1 = "TREE";
        String str2 = "JAVA";
        String str3 = "NOSTALGIA";
        String str4 = "JACKET";

        System.out.println("Проверка строки 'str1': " + Condition.test(str1));
        System.out.println("Проверка строки 'str2': " + Condition.test(str2));
        System.out.println("Проверка строки 'str3': " + Condition.test(str3));
        System.out.println("Проверка строки 'str4': " + Condition.test(str4));
    }
}