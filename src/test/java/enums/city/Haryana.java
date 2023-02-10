package enums.city;

public enum Haryana {
    KARNAL("Karnal"),
    PANIPAT("Panipat");

    private final String value;

    Haryana(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
