package enums.city;

public enum Rajasthan {
    JAIPUR("Jaipur"),
    JAISELMER("Jaiselmer");

    private final String value;

    Rajasthan(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
