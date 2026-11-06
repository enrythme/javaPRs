package pr5;

public final class Dissertation extends Publication {
    public Dissertation(String id, String title, int year, String author) { super(id, title, year, author); }
    @Override public int finePerDay() { return 50; }
    @Override public int loanDays() { return 30; }
    @Override public String type() { return "DISSERTATION"; }
}
