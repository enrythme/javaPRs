package pr4;

import java.util.Arrays;

public final class Reader {
    private final String name;
    private Book[] borrowed = new Book[0];

    public Reader(String name) { this.name = name; }
    public String getName() { return name; }

    void add(Book book) {
        borrowed = Arrays.copyOf(borrowed, borrowed.length + 1);
        borrowed[borrowed.length - 1] = book;
    }

    void remove(Book book) {
        Book[] result = new Book[borrowed.length - 1];
        int index = 0;
        for (Book item : borrowed) if (item != book) result[index++] = item;
        borrowed = result;
    }

    void printBooks() {
        System.out.println(name);
        for (Book book : borrowed) System.out.println(book);
    }

    @Override public String toString() { return name; }
}
