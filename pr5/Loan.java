package pr5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public final class Loan {
    private final Reader reader;
    private final Publication publication;
    private final LocalDate issued;
    private LocalDate due;
    private LocalDate returned;
    private int renewals;

    Loan(Reader reader, Publication publication, LocalDate issued, LocalDate due) {
        this.reader = reader;
        this.publication = publication;
        this.issued = issued;
        this.due = due;
    }

    public Reader getReader() { return reader; }
    public Publication getPublication() { return publication; }
    public LocalDate getIssued() { return issued; }
    public LocalDate getDue() { return due; }
    public LocalDate getReturned() { return returned; }
    public int getRenewals() { return renewals; }
    public boolean isReturned() { return returned != null; }
    void markReturned(LocalDate date) { returned = date; }
    void renew() { due = due.plusDays(publication.loanDays()); renewals++; }
    void setReturned(LocalDate value) { returned = value; }
    void setRenewals(int value) { renewals = value; }

    public long fine(LocalDate today) {
        long overdueDays = Math.max(0, ChronoUnit.DAYS.between(due, returned == null ? today : returned));
        return overdueDays * publication.finePerDay();
    }

    @Override
    public String toString() {
        return reader.getName() + " | " + publication + " | " + issued + " - " + due +
                (returned == null ? "" : " | возврат " + returned) + " | штраф " + fine(LocalDate.now());
    }
}
