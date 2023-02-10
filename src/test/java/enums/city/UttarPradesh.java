package enums.city;

public enum UttarPradesh {
    AGRA("Agra"),
    LUCKNOW("Lucknow"),
    MERRUT("Merrut");

    private final String value;

    UttarPradesh(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
