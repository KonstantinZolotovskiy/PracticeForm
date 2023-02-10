package enums;

public enum Hobbies {
    SPORTS("Sports"),
    READING("Reading"),
    MUSIC("Music");

    private final String hobbies;

    Hobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getHobbies() {
        return hobbies;
    }
}
