import java.util.function.Predicate;

public class FirstTask {
    public static void main(String[] args) {
        // Пункт a
        Predicate<String> NotNull = s -> s != null;
        // Пункт b
        Predicate<String> NotEmpty = s -> !s.isEmpty();
        // Пункт c
        Predicate<String> NotNullAndNotEmpty = NotNull.and(NotEmpty);

        // Проверка
        String str1 = "String";
        String str2 = "";
        String str3 = null;

        System.out.println("Пункт a:");
        System.out.println("Проверка строки 'str1': " + NotNull.test(str1));
        System.out.println("Проверка строки 'str3': " + NotNull.test(str3));

        System.out.println("Пункт b:");
        System.out.println("Проверка строки 'str1': " + NotEmpty.test(str1));
        System.out.println("Проверка строки 'str2': " + NotEmpty.test(str2));

        System.out.println("Пункт c:");
        System.out.println("Проверка строки 'str1': " + NotNullAndNotEmpty.test(str1));
        System.out.println("Проверка строки 'str2': " + NotNullAndNotEmpty.test(str2));
        System.out.println("Проверка строки 'str3': " + NotNullAndNotEmpty.test(str3));
    }
}
