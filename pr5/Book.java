package pr5;

public final class Book extends Publication {
    public Book(String id, String title, int year, String author) { super(id, title, year, author); }
    @Override public int finePerDay() { return 20; }
    @Override public int loanDays() { return 14; }
    @Override public String type() { return "BOOK"; }
}
