package pr4;

import java.util.Locale;

public abstract class Book {
    private final String title;
    private final String author;
    private final int year;
    private Reader borrowedBy;

    protected Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public boolean isAvailable() { return borrowedBy == null; }

    void lendTo(Reader reader) throws LibraryException {
        if (!isAvailable()) throw new LibraryException("Книга уже выдана");
        borrowedBy = reader;
    }

    void returnFrom(Reader reader) throws LibraryException {
        if (borrowedBy != reader) throw new LibraryException("Книга не числится у этого читателя");
        borrowedBy = null;
    }

    protected abstract String getType();

    @Override
    public String toString() {
        return getType() + ": " + title + ", " + author + ", " + year + (isAvailable() ? ", доступна" : ", выдана");
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Book)) return false;
        Book other = (Book) object;
        return title.equalsIgnoreCase(other.title) && author.equalsIgnoreCase(other.author) && year == other.year;
    }

    @Override
    public int hashCode() {
        return (title.toLowerCase(Locale.ROOT) + author.toLowerCase(Locale.ROOT) + year).hashCode();
    }
}
