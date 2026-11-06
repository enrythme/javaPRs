package pr5;

public abstract class Publication {
    private final String inventoryId;
    private String title;
    private int year;
    private String author;
    private boolean available = true;

    protected Publication(String inventoryId, String title, int year, String author) {
        this.inventoryId = inventoryId;
        this.title = title;
        this.year = year;
        this.author = author;
    }

    public String getInventoryId() { return inventoryId; }
    public String getTitle() { return title; }
    public int getYear() { return year; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }
    void setAvailable(boolean value) { available = value; }

    void edit(String newTitle, int newYear, String newAuthor) {
        title = newTitle;
        year = newYear;
        author = newAuthor;
    }

    public abstract int finePerDay();
    public abstract int loanDays();
    public abstract String type();

    String encode() {
        return type() + "\t" + inventoryId + "\t" + title + "\t" + year + "\t" + author + "\t" + available;
    }

    @Override
    public String toString() {
        return type() + " " + inventoryId + " | " + title + " | " + author + " | " + year + " | " + (available ? "доступно" : "выдано");
    }

    @Override
    public boolean equals(Object value) {
        return value instanceof Publication && inventoryId.equals(((Publication) value).inventoryId);
    }

    @Override
    public int hashCode() { return inventoryId.hashCode(); }
}
