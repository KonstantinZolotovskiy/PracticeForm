package enums;

public enum Subjects {
    ENGLISH("English"),
    COMPUTER_SCIENCE("Computer Science"),
    BIOLOGY("Biology");

    private final String subject;

    Subjects(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
}
