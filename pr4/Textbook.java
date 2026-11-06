package pr4;

public final class Textbook extends Book {
    private final String subject;

    public Textbook(String title, String author, int year, String subject) {
        super(title, author, year);
        this.subject = subject;
    }

    @Override protected String getType() { return "Учебник"; }
    @Override public String toString() { return super.toString() + ", предмет: " + subject; }
}
