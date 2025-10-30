import java.util.Random;
import java.util.function.Supplier;

public class FifthTask {
    public static void main(String[] args) {

        Supplier<Integer> RandomNumber = () -> new Random().nextInt(11);

        // Проверка
        System.out.println("Случайное число от 0 до 10: " + RandomNumber.get());
    }
}
