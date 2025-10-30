package SeventhTask;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SeventhTask {
    public static void main(String[] args) {
        Client cl1 = new Client(1, "Octavius", 30, List.of(new Phone("88005553535", Phone.PhoneType.MOBILE)));
        Client cl2 = new Client(2, "Tiberius", 25, List.of(new Phone("11-11-11", Phone.PhoneType.STATIONARY)));
        Client cl3 = new Client(3, "Domitianus", 22, List.of(new Phone("50-50-50", Phone.PhoneType.STATIONARY)));
        Client cl4 = new Client(4, "Maximus", 18, List.of(new Phone("89998881020", Phone.PhoneType.MOBILE)));

        List<Client> clients = List.of(cl1, cl2, cl3, cl4);
        Optional<Client> YoungestWithMobile = clients.stream().filter(client -> client.getPhones().stream()
                .anyMatch(phone -> phone.getType() == Phone.PhoneType.MOBILE))
                .min(Comparator.comparingInt(Client::getAge));

        YoungestWithMobile.ifPresent(client -> System.out.print("Самый молодой клиент с мобильным телефоном: "
                + client.getName()));
    }
}
