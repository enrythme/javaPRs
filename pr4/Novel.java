package pr4;

public final class Novel extends Book {
    private final String genre;

    public Novel(String title, String author, int year, String genre) {
        super(title, author, year);
        this.genre = genre;
    }

    @Override protected String getType() { return "Роман"; }
    @Override public String toString() { return super.toString() + ", жанр: " + genre; }
}
