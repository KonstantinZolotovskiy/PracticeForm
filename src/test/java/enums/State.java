package enums;

public enum State {
    NCR("NCR"),
    UTTAR_PRADESH("Uttar Pradesh"),
    HARYANA("Haryana"),
    RAJASTHAN("Rajasthan");

    private final String state;

    State(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
