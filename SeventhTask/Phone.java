package SeventhTask;

public class Phone {
    enum PhoneType {
        MOBILE, STATIONARY;
    }
    private String value;
    private PhoneType type;

    public Phone(String value, PhoneType type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public PhoneType getType() {
        return type;
    }

}
