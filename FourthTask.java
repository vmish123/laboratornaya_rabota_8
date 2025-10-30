import java.util.function.Function;

public class FourthTask {
    public static void main(String[] args) {

        Function<Integer, String> CheckSign = num -> {
            if (num > 0) {
                return "Положительное число";
            } else if (num < 0) {
                return "Отрицательное число";
            } else {
                return "Ноль";
            }
        };

        // Проверка
        System.out.println("Число 10: " + CheckSign.apply(10));
        System.out.println("Число -10: " + CheckSign.apply(-10));
        System.out.println("Число 0: " + CheckSign.apply(0));
    }
}
