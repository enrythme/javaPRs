package pr5;

import java.util.Arrays;

public final class Reader {
    private final String id;
    private final String name;
    private Loan[] history = new Loan[0];

    public Reader(String id, String name) { this.id = id; this.name = name; }
    public String getId() { return id; }
    public String getName() { return name; }
    void addLoan(Loan loan) { history = Arrays.copyOf(history, history.length + 1); history[history.length - 1] = loan; }

    int activeCount() {
        int count = 0;
        for (Loan loan : history) if (!loan.isReturned()) count++;
        return count;
    }

    @Override public String toString() { return id + " | " + name + " | активных выдач: " + activeCount(); }
    @Override public boolean equals(Object value) { return value instanceof Reader && id.equals(((Reader) value).id); }
    @Override public int hashCode() { return id.hashCode(); }
}
