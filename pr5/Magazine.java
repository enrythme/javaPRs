package pr5;

public final class Magazine extends Publication {
    public Magazine(String id, String title, int year, String author) { super(id, title, year, author); }
    @Override public int finePerDay() { return 10; }
    @Override public int loanDays() { return 7; }
    @Override public String type() { return "MAGAZINE"; }
}
