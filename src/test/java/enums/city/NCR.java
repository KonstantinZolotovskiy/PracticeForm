package enums.city;

public enum NCR {
    DELHI("Delhi"),
    GURGAON("Gurgaon"),
    NOIDA("Noida");

    private final String value;

    NCR(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
