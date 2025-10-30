package ThirdTask;

import java.util.function.Consumer;

public class ThirdTask {
    public static void main(String[] args) {

        // Создание объекта HeavyBox
        HeavyBox box = new HeavyBox(24.5F);

        Consumer<HeavyBox> Shipment = b -> System.out.println("Отгрузили ящик с весом " + b.getWeight());
        Consumer<HeavyBox> Sending = b -> System.out.println("Отправляем ящик с весом " + b.getWeight());

        // Проверка
        Shipment.andThen(Sending).accept(box);
    }
}
